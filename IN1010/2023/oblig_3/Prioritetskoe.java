
class Prioritetskoe <E extends Comparable <E>> extends Lenkeliste <E>{

    public void leggTil(E x){

        Node peker = foersteNode;
        Node nyNode = new Node(x);

        //sjekker for tom liste
        if (stoerrelse() != 0){
            //itererer gjennom listen med pekerem, og for hver sin neste så sjekker om elementet sendt enten er
            //lik eller mindre, deretter return; for å hoppe ut
            while (peker.neste != null){
                if (nyNode.data.compareTo(peker.neste.data) == 0 || nyNode.data.compareTo(peker.neste.data) == -1){
                    //følger samme logikk som i klasse IndeksertListe
                    Node tmp = peker; 
                    nyNode.neste = tmp.neste; 
                    tmp.neste = nyNode; 
                    iBruk++;;
                    return;
                }
                //exception er hvis start node allerede er større enn element
                else if (nyNode.data.compareTo(peker.data) == 0 || nyNode.data.compareTo(peker.data) == -1){
                    if (peker == foersteNode){
                        //følger samme logikk som i klasse Stabel 
                        foersteNode = nyNode; 
                        foersteNode.neste = peker;
                        iBruk++;
                        return;
                    }
                }
                peker = peker.neste; //oppdaterer peker
            }
            //ferdig iterert gjennom listen uten at if sjekkene ga true
            if (peker.neste == null){
                //tilfelle kan være at start node verken har en neste og elementet er mindre enn sluttpeker
                if (nyNode.data.compareTo(peker.data) == 0 || nyNode.data.compareTo(peker.data) == -1){
                    foersteNode = nyNode; 
                    foersteNode.neste = peker;
                    iBruk++;
                    return;
                //men dersom elementet kun er større enn alt i listen, så er det bare å legge til på slutten
                }else{
                    super.leggTil(x);
                }
            }
        //hvis listen er tom til å begynne med så er det bare å automatisk sette start node
        }else{
            foersteNode = nyNode;
            iBruk++;
        }
    }
}
