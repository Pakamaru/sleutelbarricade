package models.levels;

public class Level1 extends Level{
    public Level1(){
        this.tileCreator = new int[][][]{
                //    NORMAL = 0;
                //    KEY = 1;
                //    BARRIER = 2;
                //    WALL = 3;
                //    END = 4;
                {{}, {}, {}, {}, {}, {}, {}, {}, {}, {}},
                {{}, {}, {}, {1, 400}, {}, {1, 200}, {}, {1, 300}, {3}, {}},
                {{3}, {3}, {3}, {3}, {3}, {3}, {3}, {3}, {3}, {}},
                {{2, 400}, {}, {}, {}, {}, {}, {2, 400}, {}, {3}, {}},
                {{1, 100}, {3}, {2, 100}, {3}, {3}, {3}, {}, {}, {3}, {}},
                {{1,500}, {3}, {}, {3},{4}, {3}, {}, {3}, {3}, {}},
                {{1, 400}, {3}, {}, {3}, {2, 500}, {3}, {}, {3}, {2, 300}, {2, 400}},
                {{2, 200}, {3}, {}, {}, {}, {3}, {}, {3}, {1,100}, {2, 400}},
                {{}, {3}, {3},{3}, {3}, {3}, {}, {3}, {3}, {2, 100}},
                {{2, 100}, {}, {}, {}, {}, {}, {}, {}, {}, {}}
        };
        fixLayout();
        createMap();
    }
}