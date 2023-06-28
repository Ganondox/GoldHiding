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

    //TODO: Add a print so the unexploitable strategies can be understood

}
