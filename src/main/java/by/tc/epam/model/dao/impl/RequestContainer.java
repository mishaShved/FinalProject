package by.tc.epam.model.dao.impl;

public final class RequestContainer {

    private RequestContainer(){};

    public static final String ADD_EVENT_REQUEST =
            "INSERT INTO `bukmaker`.`event` (`id`, `time`, `team1`, `team2`, `sport_id`)" +
                    " VALUES (?, ?, ?, ?, ?);";

    public static final String SELECT_ALL_EVENTS_REQUEST =
            "SELECT b.id, b.time, b.team1, b.team2, s.sport_type FROM bukmaker.event as b " +
                    "join bukmaker.sport as s on b.sport_id = s.id " +
                    "where b.time > curdate();";

    public static final String SELECT_PART_EVENTS_REQUEST =
            "SELECT b.id, b.time, b.team1, b.team2, s.sport_type FROM bukmaker.event as b " +
                    "join bukmaker.sport as s on b.sport_id = s.id " +
                    "where s.sport_type = ? " +
                    "and b.time > curdate();";

    public static final String CREATE_ODD =
            "INSERT INTO `bukmaker`.`odd` (`id`, `event_id`, `type_id`, `coefficient`, `param`) " +
                    "VALUES (?, ?, ?, ?, ?);";

    public static final String GET_ODD_BY_EVENT =
            "SELECT o.id, e.team1, e.team2, t.type, o.coefficient, o.param FROM bukmaker.odd as o\n" +
                    "join bukmaker.event as e on o.event_id = e.id\n" +
                    "join bukmaker.odd_type as t on o.type_id = t.id\n" +
                    "where o.event_id = ?;";

    public static final String CREATE_STACKE =
            "INSERT INTO `bukmaker`.`stake` " +
                    "(`id`, `odd_id`, `user_id`, `money`, `coefficient`) " +
                    "VALUES (?, ?, ?, ?, ?);";

    public static final String USER_ADD_REQUEST =
            "INSERT INTO `bukmaker`.`user` (`id`, `name`, `password`, `balance`, `user_type_id`, `email`)" +
                    " VALUES (?, ?, ?, '0', '2', ?);";

    public static final String GET_USER_REQUEST =
            "SELECT u.id, u.name, u.balance, u.email, t.type AS userType FROM bukmaker.user AS u\n" +
                    "JOIN user_type AS t ON u.user_type_id = t.id\n" +
                    "WHERE u.id = ? AND u.password = ?";

    public static final String SET_BALANCE_REQUEST =
            "UPDATE `bukmaker`.`user` SET `balance`=? WHERE `id`=?;";

    public static final String GET_BALANCE_REQUEST =
            "SELECT `user`.`balance` FROM `bukmaker`.`user` WHERE `id`=?;";
}
