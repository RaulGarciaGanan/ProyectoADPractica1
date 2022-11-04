package Clases;

import java.io.Serializable;

public class Partido implements Serializable {
    int codEquipo1;
    int codEquipo2;
    int goles1;
    int goles2;

    public Partido(int codEquipo1, int getCodEquipo2, int goles1, int goles2) {
        this.codEquipo1 = codEquipo1;
        this.codEquipo2 = getCodEquipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }

    public int getCodEquipo1() {
        return codEquipo1;
    }

    public void setCodEquipo1(int codEquipo1) {
        this.codEquipo1 = codEquipo1;
    }

    public int getCodEquipo2() {
        return codEquipo2;
    }

    public void setCodEquipo2(int codEquipo2) {
        this.codEquipo2 = codEquipo2;
    }

    public int getGoles1() {
        return goles1;
    }

    public void setGoles1(int goles1) {
        this.goles1 = goles1;
    }

    public int getGoles2() {
        return goles2;
    }

    public void setGoles2(int goles2) {
        this.goles2 = goles2;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "codEquipo1=" + codEquipo1 +
                ", getCodEquipo2=" + codEquipo2 +
                ", goles1=" + goles1 +
                ", goles2=" + goles2 +
                '}';
    }
}
