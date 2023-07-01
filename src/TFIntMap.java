public class TFIntMap extends TFStrategy{

    int strategy;

    public TFIntMap(int strategy) {
        this.strategy = strategy;
    }

    @Override
    Game.TFAction getAction(Game.HLAction hlAction, Game.HFAction hfAction, Game.TLAction tlAction) {

        //convert observation to index, ignoring hfaction because we're assuming a pure strategy so the hfaction is determined by the hlaction
        int observation = 0;
        switch (hlAction){
            case hsignal1:
                observation = 0;
                break;
            case hsignal2:
                observation = 2;
                break;
            case hsignal3:
                observation = 4;
                break;
        }

        if(tlAction == Game.TLAction.tsignal2){
            observation++;
        }

        //extract the strategic component
        int component = strategy;
        for(int i = 0; i < observation; i++){
            component /= 3;
        }
        component %= 3;

        //action determined by extracted component
        switch (component){
            case 0:
                return Game.TFAction.search1;
            case 1:
                return Game.TFAction.search2;
            case 2:
                return Game.TFAction.search3;
        }
        return Game.TFAction.search1;
    }

    @Override
    public String toString() {
        String string = "";
        Game.HLAction hlAction = Game.HLAction.hsignal2;
        Game.HFAction hfAction = Game.HFAction.cycleRight;
        Game.TLAction tlAction = Game.TLAction.tsignal1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
               string += "h" + (i + 1) + " t" + (j + 1) +":";
               char search = '2';
               switch (i){
                   case 0:
                       hlAction = Game.HLAction.hsignal1;
                       break;
                   case 1:
                       hlAction = Game.HLAction.hsignal2;
                       break;
                   case 2:
                       hlAction = Game.HLAction.hsignal3;
                       break;
               }
               switch (j){
                   case 0:
                       tlAction = Game.TLAction.tsignal1;
                       break;
                   case 1:
                       tlAction = Game.TLAction.tsignal2;
                       break;
               }
               switch (getAction(hlAction,hfAction,tlAction)){
                   case search1:
                       search = '1';
                       break;
                   case search2:
                       search = '2';
                       break;

                       case search3:
                       search = '3';
                       break;
               }
               string += search + "\n";
            }
        }
        return string;
    }
}
