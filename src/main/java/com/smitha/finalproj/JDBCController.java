package com.smitha.finalproj;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

@RestController
public class JDBCController {
    private final static String KEYFILEPATH = "keyFile.key";

    @CrossOrigin
    @RequestMapping(value = "/printAllUsers", method = RequestMethod.GET)
    public String printAllUsers() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();
        String queryStr = "SELECT * from user_info;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("user_id")).append(", ")
                    .append(sqlRowSet.getString("first_name")).append(", ")
                    .append(sqlRowSet.getString("last_name")).append(", ")
                    .append(sqlRowSet.getString("addr")).append(", ")
                    .append(sqlRowSet.getString("phone")).append(", ")
                    .append(sqlRowSet.getString("email")).append(", ")
                    .append(sqlRowSet.getString("created_at"))
                    .append("\n");
        }
        return ("SELECT * from user_info:\n" +"id"+", "+"FirstName"+", "+"LastName"+", "+"Address" +", "+"Phone"+", "+ "Email" +", "+"Created At\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestBody AddUserData addUserData) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "INSERT INTO user_info (first_name, last_name, addr, email,phone) " +
                "VALUES (" +
                "'" + addUserData.getFirstName() + "'," +
                "'" + addUserData.getLastName() + "'," +
                "'" + addUserData.getAddress() + "'," +
                "'" + addUserData.getEmail() + "'," +
                "'" + addUserData.getPhone() + "'" +
                ");";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

    @CrossOrigin
    @RequestMapping(value = "/printAllItems", method = RequestMethod.GET)
    public String printAllItems() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        String queryStr = "SELECT * from item_info;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("item_id")).append(", ")
                    .append(sqlRowSet.getString("item_name")).append(", ")
                    .append(sqlRowSet.getString("unit")).append(", ")
                    .append(sqlRowSet.getString("created_at"))
                    .append("\n");
        }
        return ("SELECT * from item_info:\n"+"id"+", "+ "ItemName"+", "+"Unit"+", "+"Created At"+" \n"+ resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItem(@RequestBody AddItemData addItemData) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "INSERT INTO item_info (item_name, unit) " +
                "VALUES (" +
                "'" + addItemData.getItemName() + "'," +
                "'" + addItemData.getUnit() + "'" +
                ");";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

    @CrossOrigin
    @RequestMapping(value = "/printAllOfferRequest", method = RequestMethod.GET)
    public String printAllOfferRequest() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        String queryStr = "SELECT * from offer_request_details;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("id")).append(", ")
                    .append(sqlRowSet.getString("item_id")).append(", ")
                    .append(sqlRowSet.getString("person_id")).append(", ")
                    .append(sqlRowSet.getString("quantity")).append(", ")
                    .append(sqlRowSet.getString("type")).append(", ")
                    .append(sqlRowSet.getString("created_at"))
                    .append("\n");
        }
        return ("SELECT * from offer_request_details:\n" + "id"+", "+"Item Id"+", "+"Person Id"+", "+"Quantity"+", "+"Type"+", "+"Created At"+" \n"+resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/addOfferRequest", method = RequestMethod.POST)
    public String addOfferRequest(@RequestBody OfferRequestDetails offerRequestDetails) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "INSERT INTO offer_request_details (item_id, person_id, quantity, type) " +
                "VALUES (" +
                "'" + offerRequestDetails.getItemID() + "'," +
                "'" + offerRequestDetails.getPersonID() + "'," +
                "'" + offerRequestDetails.getQuantity() + "'," +
                "'" + offerRequestDetails.getType() + "'" +
                ");";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateOfferRequest", method = RequestMethod.POST)
    public String updateOfferRequest(@RequestBody OfferRequestDetails offerRequestDetails) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "UPDATE offer_request_details SET quantity =" +
                "'" + offerRequestDetails.getQuantity() + "'"+
                 "WHERE item_id = " +
                "'" + offerRequestDetails.getItemID() + "'" +
                "AND person_id = "+
                "'" + offerRequestDetails.getPersonID() + "'" +
                ";";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

}
