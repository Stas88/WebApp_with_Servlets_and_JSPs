package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Dept {

    private int deptno;
    private String dname;
    private String loc;

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Dept() {
    }

    public int getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
