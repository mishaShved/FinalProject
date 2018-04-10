package by.tc.epam.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OddsList {

    private List<Odd> odds;

    public OddsList() {
        odds = new ArrayList<>();
    }

    public void addOdd(Odd odd){
        odds.add(odd);
    }

    public Odd getOdd(String type){
        OddType oddType = OddType.valueOf(type);
        for(Odd odd : odds){
            if(odd.getOddType() == oddType){
                return odd;
            }
        }
        return null;
    }

    public Odd getOdd(int index){
        return odds.get(index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OddsList oddsList = (OddsList) o;
        return Objects.equals(odds, oddsList.odds);
    }

    @Override
    public int hashCode() {

        return Objects.hash(odds);
    }

    @Override
    public String toString() {
        return "OddsList{" +
                "odds=" + odds +
                '}';
    }
}
