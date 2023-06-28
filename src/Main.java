public class Main {
    public static void main(String[] args) {



        System.out.println("Hello world!");


        int losses = 0;
        for(int i = 0; i < 729; i++){

            TFStrategy  tfStrategy = new TFIntMap(i);
            HFStrategy hfStrategy = new HFCycler();
            //HFStrategy hfStrategy = new HFSwapper();
            //HFStrategy hfStrategy = new HFAdjacent();
            //HFStrategy hfStrategy = new HFBlindStrategy(Game.HFAction.identity);
            TLStrategy tlStrategy = new TLBestResponse(tfStrategy);
            //TLStrategy tlStrategy = new TLBlindStrategy(Game.TLAction.tsignal1);
            HLStrategy hlStrategy = new HLBestResponse(hfStrategy, tlStrategy, tfStrategy);
            //HLStrategy hlStrategy = new HLBlindStrategy(Game.HLAction.hsignal1);
            //HLStrategy hlStrategy = new HLTransparent();


            double ev = Game.getEV(hlStrategy,hfStrategy,tlStrategy,tfStrategy);
            if(ev < 0.5){
                System.out.println(i);
                System.out.println(ev);
                losses++;
            }

        }
        System.out.println(losses);

    }


}