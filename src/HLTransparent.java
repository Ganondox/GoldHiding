public class HLTransparent extends HLStrategy{

    @Override
    Game.HLAction getAction(Game.MNAction mnAction) {
        switch (mnAction){
            case hide1:
                return Game.HLAction.hsignal1;
            case hide2:
                return Game.HLAction.hsignal2;
            case hide3:
                return Game.HLAction.hsignal3;
        }
        return Game.HLAction.hsignal1;
    }
}
