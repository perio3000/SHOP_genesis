package edu.global.ex.dao;

import edu.global.ex.dto.SDto;
import edu.global.ex.dto.SDto_rank;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SDao {
    private DataSource dataSource = null;

    public SDao() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


    public List<SDto> list() {
        ArrayList<SDto> dtos = new ArrayList<>();
        System.out.println("List<SDto> list() {...........");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            String query = "select * from member_tbl_02 order by custno";
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            System.out.println("쿼리 완료");

            while (rs.next()) {
                int custno = rs.getInt("custno");
                String custname = rs.getString("custname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date joindate = rs.getDate("joindate");
                String grade = rs.getString("grade");
                String city = rs.getString("city");
                System.out.println(custname);
                SDto dto = new SDto(custno, custname, phone, address, joindate, grade, city);
                dtos.add(dto);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return dtos;
    }


    public List<SDto_rank> rank() {
        ArrayList<SDto_rank> dtos = new ArrayList<>();
        System.out.println("List<SDto_rank> rankList() {...........");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            String query = "SELECT A.CUSTNO, A.CUSTNAME, A.GRADE, SUM(B.PRICE) AS TOTAL\n" +
                    "FROM MEMBER_TBL_02 A JOIN MONEY_TBL_02 B ON A.CUSTNO = B.CUSTNO\n" +
                    "GROUP BY(A.CUSTNO, A.CUSTNAME, A.GRADE)\n" +
                    "ORDER BY TOTAL DESC";
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            System.out.println("쿼리 완료");

            while (rs.next()) {
                int custno = rs.getInt("custno");
                String custname = rs.getString("custname");
                String grade = rs.getString("grade");
                int total = rs.getInt("total");

                System.out.println(custname);
                SDto_rank dto = new SDto_rank(custno, custname, grade, total);
                dtos.add(dto);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return dtos;
    }


    public void join(String custname, String phone, String address, String joindate, String grade, String city) {
        System.out.println("join()....");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into member_tbl_02" + "(custno, custname, phone, address, joindate, grade, city)" + "values (member_seq.nextval,?,?,?,?,?,?)";
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, custname);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, joindate);
            preparedStatement.setString(5, grade);
            preparedStatement.setString(6, city);

            int check = preparedStatement.executeUpdate();
            System.out.println("업데이트 갯수 :" + check);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public SDto selectOne(String cno) {

        SDto dto = null;


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "select custno, " + "custname, " + "phone, " + "address, " + "joindate, " + "grade, " + "city from member_tbl_02 where custno = ?";

            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.valueOf(cno));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int custno = resultSet.getInt("custno");
                String custname = resultSet.getString("custname");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Date joindate = resultSet.getDate("joindate");
                String grade = resultSet.getString("grade");
                String city = resultSet.getString("city");
                dto = new SDto(custno, custname, phone, address, joindate, grade, city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return dto;
    }

    public void update(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
        System.out.println("update()....");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String query = "update member_tbl_02 " + "set custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? " + "where custno=?";
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, custname);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, joindate);
            preparedStatement.setString(5, grade);
            preparedStatement.setString(6, city);

            preparedStatement.setInt(7, custno);

            int check = preparedStatement.executeUpdate();
            System.out.println("업데이트 갯수 :" + check);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
