public class Game {

    enum MNAction {hide1, hide2, hide3}

    enum HLAction {hsignal1, hsignal2, hsignal3}

    enum HFAction {swap12, swap13, swap23, cycleRight, cycleLeft, identity}

    enum TLAction {tsignal1, tsignal2}

    enum TFAction {search1, search2, search3}

    //true if hiders win
    static boolean play(MNAction mnAction, HLStrategy hlStrategy, HFStrategy hfStrategy, TLStrategy tlStrategy, TFStrategy tfStrategy) {
        int goldPos = 0;
        switch (mnAction) {
            case hide1:
                goldPos = 0;
                break;
            case hide2:
                goldPos = 1;
                break;
            case hide3:
                goldPos = 2;
                break;
        }

        HLAction a1 = hlStrategy.getAction(mnAction);
        HFAction a2 = hfStrategy.getAction(a1);
        switch (a2) {
            case swap12:
                if (goldPos != 2) goldPos = 1 - goldPos;
                break;
            case swap13:
                if (goldPos != 1) goldPos = 2 - goldPos;
                break;
            case swap23:
                if (goldPos != 0) goldPos = 3 - goldPos;
                break;
            case cycleRight:
                goldPos = (goldPos + 1) % 3;
                break;
            case cycleLeft:
                goldPos = (goldPos + 2) % 3;
                break;
            case identity:
                break;
        }

        TLAction a3 = tlStrategy.getAction(mnAction, a1, a2);
        TFAction a4 = tfStrategy.getAction(a1, a2, a3);
        switch (a4) {
            case search1:
                return goldPos != 0;
            case search2:
                return goldPos != 1;
            case search3:
                return goldPos != 2;
        }
        return false;
    }

    static boolean play(HLStrategy hlStrategy, HFStrategy hfStrategy, TLStrategy tlStrategy, TFStrategy tfStrategy) {

        int nat = (int) (Math.random() * 3);

        MNAction mnAction = MNAction.hide1;

        switch (nat) {
            case 1:
                mnAction = MNAction.hide1;
                break;
            case 2:
                mnAction = mnAction.hide2;
                break;
            case 3:
                mnAction = mnAction.hide3;
                break;
        }

        return play(mnAction, hlStrategy, hfStrategy, tlStrategy, tfStrategy);

    }

    //gives probability  that the hiders win assuming the all stategies are pure
  static double getEV(HLStrategy hlStrategy, HFStrategy hfStrategy, TLStrategy tlStrategy, TFStrategy tfStrategy){
        double wins = 0;
        if(play(MNAction.hide1, hlStrategy, hfStrategy, tlStrategy, tfStrategy)) wins++;
        if(play(MNAction.hide2, hlStrategy, hfStrategy, tlStrategy, tfStrategy)) wins++;
        if(play(MNAction.hide3, hlStrategy, hfStrategy, tlStrategy, tfStrategy)) wins++;
        return wins/3;
    }
}
