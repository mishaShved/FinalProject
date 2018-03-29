package by.tc.epam.model.entity;

public enum OddType {

    W1{
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 > score2){
                return true;
            }
            return false;
        }
    },

    W2{
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 < score2){
                return true;
            }
            return false;
        }
    },

    X {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 == score2){
                return true;
            }
            return false;
        }
    },

    X1 {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 >= score2){
                return true;
            }
            return false;
        }
    },

    X2 {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 <= score2){
                return true;
            }
            return false;
        }
    },

    NOTX {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 != score2){
                return true;
            }
            return false;
        }
    },

    F1 {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 + param > score2){
                return true;
            }
            return false;
        }
    },

    F2 {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 < score2 + param){
                return true;
            }
            return false;
        }
    },

    TM {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 + score2 > param){
                return true;
            }
            return false;
        }
    },

    TL {
        @Override
        public boolean isWon(int score1, int score2, double param) {
            if (score1 + score2 < param){
                return true;
            }
            return false;
        }
    };

    abstract public boolean isWon(int score1, int score2, double param);

}
