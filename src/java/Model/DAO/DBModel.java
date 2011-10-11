package Model.DAO;

import java.sql.*;
import java.util.*;
import Model.*;
import javax.naming.*;
import javax.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.*;
import org.apache.log4j.*;
import javax.transaction.UserTransaction;
import javax.transaction.*;

/**
 *
 * @author Admin
 */
public class DBModel implements IModel {

    private static Logger logger = Logger.getRootLogger();
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private UserTransaction uTransaction = null;

    //Обработка ResultSet-ов
    private List<Emp> getEmpsFromResultSet(ResultSet resultSet) throws ModelException {
        try {
            List<Emp> empList = new ArrayList<Emp>();
            while (resultSet.next()) {
                int empn = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                String job = resultSet.getString(3);
                int mgr = getMgr(resultSet.getString(4));
                java.util.Date hiredate = resultSet.getDate(5);
                int sal = resultSet.getInt(6);
                int comm = resultSet.getInt(7);
                int deptno = resultSet.getInt(8);
                System.out.println(empn + " " + ename + " " + job + " " + mgr + " " + hiredate + " " + sal + " " + comm + " " + deptno);
                empList.add(new Emp(empn, ename, job, mgr, hiredate, sal, comm, deptno));
            }
            return empList;
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        }

    }

    private List<Dept> getDeptsFromResultSet(ResultSet resultSet) throws ModelException {
        try {
            List<Dept> deptList = new ArrayList<Dept>();
            while (resultSet.next()) {
                int deptno = resultSet.getInt("Deptno");
                String dname = resultSet.getString("Dname");
                String loc = resultSet.getString("Loc");
                System.out.println(deptno + " " + dname + " " + loc);
                deptList.add(new Dept(deptno, dname, loc));
            }
            return deptList;
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        }
    }

    private List<SalGrade> getSalGradesFromResultSst(ResultSet resultSet) throws ModelException {
        try {
            List<SalGrade> salGradeList = new ArrayList<SalGrade>();
            while (resultSet.next()) {
                int grade = resultSet.getInt("Grade");
                double minSal = resultSet.getDouble("minSal");
                double maxSal = resultSet.getDouble("hiSal");
                salGradeList.add(new SalGrade(grade, minSal, maxSal));
            }
            return salGradeList;
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        }
    }

    //Закрытие всего
    public void close() throws ModelException {
        try {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } finally {
                    try {
                        if (statement != null) {
                            statement.close();
                        }
                    } finally {
                        if (connection != null) {
                            connection.close();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        }
    }

    //Открытие коннекшна
    public Connection getConnection() throws ModelException {
        try {
            logger.info("Getting connection from DB");
            Hashtable ht = new Hashtable();
            ht.put(Context.INITIAL_CONTEXT_FACTORY,
                    "weblogic.jndi.WLInitialContextFactory");
            ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
            Context context = new InitialContext(ht);
            DataSource ds = (DataSource) context.lookup("Lab_connection");
            connection = ds.getConnection();
        } catch (NamingException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        }
        return connection;
    }

    //Transactions 
    public void start() throws ModelException {
        try {
            Context context = new InitialContext();
            uTransaction = (UserTransaction) context.lookup("java:comp/UserTransaction");
            uTransaction.begin();
        } catch (NamingException ne) {
            throw new ModelException(ne.getMessage());
        } catch (NotSupportedException nse) {
            throw new ModelException(nse.getMessage());
        } catch (SystemException se) {
            throw new ModelException(se.getMessage());
        }
    }

    public void commit() throws ModelException {
        try {
            uTransaction.commit();
        } catch (HeuristicMixedException ne) {
            throw new ModelException(ne.getMessage());
        } catch (HeuristicRollbackException nse) {
            throw new ModelException(nse.getMessage());
        } catch (RollbackException re) {
            throw new ModelException(re.getMessage());
        } catch (SystemException se) {
            throw new ModelException(se.getMessage());
        }
    }

    public void rollback() throws ModelException {
        try {
            uTransaction.rollback();
        } catch (SystemException se) {
            throw new ModelException(se.getMessage());
        }
    }

    //------------------------------------------------------Методы с запросами----------------------------------------
    @Override
    public Collection<Emp> getParentIerarhy(int empno) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.GET_EMP_PARENT_IERARHY);
            preparedStatement.setInt(1, empno);
            resultSet = preparedStatement.executeQuery();
            List<Emp> empList = getEmpsFromResultSet(resultSet);
            Collections.reverse(empList);
            return empList;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Collection<Dept> getDeptList() throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Commands.GET_ALL_DEPTS);
            return getDeptsFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<SalGrade> getSalGradeList() throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Commands.GET_ALL_SALGRADES);
            return getSalGradesFromResultSst(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<Emp> getEmpList() throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Commands.GET_ALL_EMPS);
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<Emp> getSortedEmps(String sortBy) throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            if (sortBy.equals("ByNameDsc")) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_DSC_NAME);
            } else if ("ByNameAsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_ASC_NAME);
            } else if ("BySalAsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_ASC_SAL);
            } else if ("BySalDsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_DSC_SAL);
            } else if ("ByHiredateAsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_ASC_HIREDATE);
            } else if ("ByHiredateDsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_EMPS_DSC_HIREDATE);
            }
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    public Collection<Dept> getSortedDepts(String sortBy) throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            if ("ByLocAsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_DEPTS_ASC_LOC);
            } else if ("ByLocDsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_DEPTS_DSC_LOC);
            }
            return getDeptsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Collection<SalGrade> getSortedSalGrades(String sortBy) throws ModelException {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            if ("ByGradeAsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_SALGRADES_ASC_GRADE);
            } else if ("ByGradeDsc".equals(sortBy)) {
                resultSet = statement.executeQuery(Commands.GET_ALL_SALGRADES_DSC_GRADE);
            }
            return getSalGradesFromResultSst(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<Emp> getIerarhy(int empno) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.GET_EMP_IERARHY);
            preparedStatement.setInt(1, empno);
            preparedStatement.setInt(2, empno);
            resultSet = preparedStatement.executeQuery();
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    private int getMgr(String mgr) {
        if (mgr == null) {
            return 0;
        } else {
            return Integer.parseInt(mgr);
        }
    }

    @Override
    public void addEmp(Emp emp) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.INSERT_IN_EMP);
            preparedStatement.setString(1, emp.getEname());
            preparedStatement.setString(2, emp.getJob());
            preparedStatement.setInt(3, emp.getMgr());
            preparedStatement.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
            preparedStatement.setDouble(5, emp.getSal());
            preparedStatement.setDouble(6, emp.getComm());
            preparedStatement.setInt(7, emp.getDeptno());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void addDept(Dept dept) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.INSERT_IN_DEPT);
            preparedStatement.setString(1, dept.getDname());
            preparedStatement.setString(2, dept.getLoc());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void addSalGrade(SalGrade salGrade) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.INSERT_IN_SALGRADE);
            preparedStatement.setDouble(1, salGrade.getMinSal());
            preparedStatement.setDouble(2, salGrade.getMaxSal());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void editEmp(Emp emp) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.UPDATE_EMP);
            preparedStatement.setString(1, emp.getEname());
            preparedStatement.setString(2, emp.getJob());
            preparedStatement.setInt(3, emp.getMgr());
            preparedStatement.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
            preparedStatement.setDouble(5, emp.getSal());
            preparedStatement.setDouble(6, emp.getComm());
            preparedStatement.setInt(7, emp.getDeptno());
            preparedStatement.setInt(8, emp.getEmpno());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void editDept(Dept dept) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.UPDATE_DEPT);
            preparedStatement.setString(1, dept.getDname());
            preparedStatement.setString(2, dept.getLoc());
            preparedStatement.setInt(3, dept.getDeptno());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void editSalGrade(SalGrade salGrade) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.UPDATE_SALGRADE);
            preparedStatement.setDouble(1, salGrade.getMaxSal());
            preparedStatement.setDouble(2, salGrade.getMinSal());
            preparedStatement.setInt(3, salGrade.getGrade());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void removeDept(int deptno) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.DELETE_DEPT_BY_DEPTNO);
            preparedStatement.setInt(1, deptno);
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void removeSalGrade(int grade) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.DELETE_SALGRADE_BY_GRADE);
            preparedStatement.setInt(1, grade);
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void removeEmp(int empno) throws ModelException {
        try {
            start();
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.DELETE_EMP_BY_EMPNO);
            preparedStatement.setInt(1, empno);
            commit();
        } catch (SQLException e) {
            rollback();
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Dept findDept(int deptno) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.GET_DEPT_BY_DEPTNO);
            preparedStatement.setInt(1, deptno);
            resultSet = preparedStatement.executeQuery();
            return getDeptsFromResultSet(resultSet).get(0);
        } catch (SQLException e) {
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public SalGrade findSalGrade(int grade) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.GET_SALGRADE_BY_GRADE);
            preparedStatement.setInt(1, grade);
            resultSet = preparedStatement.executeQuery();
            return getSalGradesFromResultSst(resultSet).get(0);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Emp findEmp(int empno) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.GET_EMP_BY_EMPNO);
            preparedStatement.setInt(1, empno);
            resultSet = preparedStatement.executeQuery();
            return getEmpsFromResultSet(resultSet).get(0);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<Dept> findDepts(String dname, String loc) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_DEPTS_DNAME_LOC);
            preparedStatement.setString(1, dname);
            preparedStatement.setString(2, loc);
            resultSet = preparedStatement.executeQuery();
            return getDeptsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Collection<Dept> findDeptsByDname(String dname) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_DEPTS_DNAME);
            preparedStatement.setString(1, dname);
            resultSet = preparedStatement.executeQuery();
            return getDeptsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<Dept> findDeptsByLoc(String loc) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_DEPTS_LOC);
            preparedStatement.setString(1, loc);
            resultSet = preparedStatement.executeQuery();
            return getDeptsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public Collection<SalGrade> findSalGradesByGrade(int grade) throws ModelException {
        Collection<SalGrade> salGradeCol = new ArrayList<SalGrade>();
        salGradeCol.add(findSalGrade(grade));
        return salGradeCol;
    }

    @Override
    public Collection<Emp> findEmps(String ename, int sal) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_EMPS_ENAME_SAL);
            preparedStatement.setString(1, ename);
            preparedStatement.setInt(2, sal);
            resultSet = preparedStatement.executeQuery();
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Collection<Emp> findEmpsByEname(String ename) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_EMPS_ENAME);
            preparedStatement.setString(1, ename);
            resultSet = preparedStatement.executeQuery();
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }

    @Override
    public Collection<Emp> findEmpsBySal(int sal) throws ModelException {
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(Commands.FIND_EMPS_SAL);
            preparedStatement.setInt(1, sal);
            resultSet = preparedStatement.executeQuery();
            return getEmpsFromResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ModelException(e.getMessage());
        } finally {
            close();
        }

    }
}
