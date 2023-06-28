public class HFSwapper extends HFStrategy{

    @Override
    Game.HFAction getAction(Game.HLAction hlAction) {
        switch (hlAction){
            case hsignal1:
                return Game.HFAction.swap12;
            case hsignal2:
                return Game.HFAction.swap13;
            case hsignal3:
                return Game.HFAction.swap23;
        }
        return Game.HFAction.identity;
    }
}
