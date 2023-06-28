public class HFAdjacent extends HFStrategy {

    @Override
    Game.HFAction getAction(Game.HLAction hlAction) {
        switch (hlAction){
            case hsignal1:
                return Game.HFAction.swap12;
            case hsignal2:
                return Game.HFAction.swap23;
            case hsignal3:
                return Game.HFAction.identity;
        }
        return Game.HFAction.identity;
    }
}

