package by.tc.epam.model.dao.transaction_dao.impl;

public final class RequestContainer {

    private RequestContainer(){};

    public static final String ADD_EVENT_REQUEST =
            "INSERT INTO `bukmaker`.`event` (`id`, `time`, `team1_ru`, `team2_ru`, `team1_en`, `team2_en`, `sport_id`, `score1`, `score2`)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, -1, -1);";

    public static final String SELECT_EVENTS_REQUEST_FOR_SET_SCORE =
            "SELECT b.id, b.time, b.team1, b.team2, s.sport_type FROM bukmaker.event as b " +
                    "join bukmaker.sport as s on b.sport_id = s.id " +
                    "where b.score1 = -1 " +
                    "and b.time < curdate();";

    public static final String CREATE_ODD =
            "INSERT INTO `bukmaker`.`odd` (`id`, `event_id`, `type_id`, `coefficient`, `param`) " +
                    "VALUES (?, ?, ?, ?, ?);";



    public static final String CREATE_STACKE =
            "INSERT INTO `bukmaker`.`stake` " +
                    "(`id`, `odd_id`, `user_id`, `money`, `coefficient`) " +
                    "VALUES (?, ?, ?, ?, ?);";

    public static final String USER_ADD_REQUEST =
            "INSERT INTO `bukmaker`.`user` (`id`, `name`, `password`, `balance`, `user_type_id`, `email`)" +
                    " VALUES (?, ?, md5(?), '0', '2', ?);";

    public static final String GET_USER_REQUEST =
            "SELECT u.id, u.name, t.type AS userType FROM bukmaker.user AS u\n" +
                    "JOIN user_type AS t ON u.user_type_id = t.id\n" +
                    "WHERE u.id = ? AND u.password = md5(?)";

    public static final String SET_BALANCE_REQUEST =
            "UPDATE `bukmaker`.`user` SET `balance`=? WHERE `id`=?;";

    public static final String GET_BALANCE_REQUEST =
            "SELECT `user`.`balance` FROM `bukmaker`.`user` WHERE `id`=?;";


    public static final String GET_ALL_STAKES_BY_EVENT_REQUEST =
            "select st.money * st.coefficient as res, st.user_id, o.param, ot.type from stake as st\n" +
                    "join odd as o on st.odd_id = o.id\n" +
                    "join event as e on o.event_id = e.id \n" +
                    "join odd_type as ot on ot.id = o.type_id    \n" +
                    "where e.id = ?;";

    public static final String SET_SCORE_REQUEST =
            "UPDATE `bukmaker`.`event` SET `score1`=?, `score2`=? WHERE `id`=?;\n";

    public static final String GET_ODD_COEF =
            "select coefficient from odd\n" +
                    "where id = ?";


    public static final String GET_ODD_OUTCOME =
            "SELECT concat(ot.type, \"(\", o.param ,\")\") as info FROM bukmaker.odd as o\n" +
                    "join odd_type as ot on ot.id = o.type_id\n" +
                    "where o.id = ?";

    public static String getRequestForGetUserStakes(String locale){

        return "select e.team1_"+ locale +" , e.team2_" + locale + " , ot.type as odd_type, o.param, \n" +
                "            sp.sport_type_" + locale + " , s.money, s.coefficient, e.score1, e.score2 from stake as s\n" +
                "            join odd as o on s.odd_id = o.id\n" +
                "            join odd_type as ot on o.type_id = ot.id\n" +
                "            join event as e on o.event_id = e.id\n" +
                "            join sport as sp on e.sport_id = sp.id\n" +
                "                    where s.user_id = ?\n" +
                "            order by e.time desc";

    }

    public static String getRequestForSelectEventsBySport(String locale){
        return "SELECT b.id, b.time, b.team1_" + locale + " as team1 , b.team2_" + locale + " as team2, s.sport_type as sportType FROM bukmaker.event as b " +
                        "join bukmaker.sport as s on b.sport_id = s.id " +
                        "where s.sport_type = ? " +
                        "and b.time > curdate();";
    }

    public static String getRequestForGetOddsByEvent(String locale){
        return "SELECT o.id, e.team1_" + locale + " as team1, e.team2_" + locale + " as team2, t.type, o.coefficient, o.param FROM bukmaker.odd as o\n" +
                        "join bukmaker.event as e on o.event_id = e.id\n" +
                        "join bukmaker.odd_type as t on o.type_id = t.id\n" +
                        "where o.event_id = ?;";
    }

    public static String getRequestForAviableEventsForAddOdd(String locale){

        return "SELECT b.id, b.time, b.team1_" + locale + " as team1, b.team2_" + locale + " as team2, " +
                "s.sport_type_" + locale + " as sportType FROM bukmaker.event as b " +
                        "join bukmaker.sport as s on b.sport_id = s.id " +
                        "where b.time > curdate();";

    }


    public static String getRequestForGetInfoAboutOdd(String locale){
        return  "SELECT concat(s.sport_type_" + locale + ", \".\", e.team1_" + locale + ",\"-\", e.team2_" + locale + ") as info FROM bukmaker.event as e\n" +
                        "join sport as s on e.sport_id = s.id\n" +
                        "join odd as o on o.event_id = e.id\n" +
                        "where o.id = ?";
    }

}
