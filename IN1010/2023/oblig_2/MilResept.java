
class MilResept extends HvitResept{

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
        settReit();
    }
    public void settReit(){
        reit = 3; //reit skal være 3 til å begynne med uansett argument som sendes inn
    }
    public int prisAaBetale(){
        return 0; //100% rabatt
    }
}