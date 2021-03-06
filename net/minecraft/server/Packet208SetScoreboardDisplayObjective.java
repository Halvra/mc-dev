package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;

public class Packet208SetScoreboardDisplayObjective extends Packet {

    public int a;
    public String b;

    public Packet208SetScoreboardDisplayObjective() {}

    public Packet208SetScoreboardDisplayObjective(int i, ScoreboardObjective scoreboardobjective) {
        this.a = i;
        if (scoreboardobjective == null) {
            this.b = "";
        } else {
            this.b = scoreboardobjective.getName();
        }
    }

    public void a(DataInput datainput) {
        this.a = datainput.readByte();
        this.b = a(datainput, 16);
    }

    public void a(DataOutput dataoutput) {
        dataoutput.writeByte(this.a);
        a(this.b, dataoutput);
    }

    public void handle(Connection connection) {
        connection.a(this);
    }

    public int a() {
        return 3 + this.b.length();
    }
}
