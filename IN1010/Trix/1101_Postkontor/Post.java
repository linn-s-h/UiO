import java.util.concurrent.locks.*;

class Post {
    
    Lock laas = new ReentrantLock();
    Condition fullPost = laas.newCondition();
    Condition ingenPost = laas.newCondition();

    String beskrivelse;
    String mottaker;
    Post(String beskrivelse, String mottaker){
        this.beskrivelse = beskrivelse;
        this.mottaker = mottaker;
    }

    public String hentMottaker(){
        return mottaker;
    }
    public String hentBeskrivelse(){
        return beskrivelse;
    }
    public String toString(){
        return "Til " + mottaker + " " + "(" + beskrivelse + ")";
    }

    //monitor
    class Postkontor{

        Post[] postArray = new Post[10];

        public int stoerrelse(){
            int stoerrelse = 0;
            for (int i = 0; i < postArray.length; i++){
                if (postArray[i] != null){
                    stoerrelse++;
                }
            }
            return stoerrelse;
        }

        public void leverPost(Post p){
            laas.lock();
            try{
                if (stoerrelse() == postArray.length){
                    fullPost.await();
                }
                for (int i = 0; i < postArray.length; i++){
                    if (postArray[i] == null){
                        postArray[i] = p;
                        fullPost.signalAll();
                        return;
                    }
                }
            } catch (InterruptedException e){
                System.out.println("Error.");
            } finally {
                laas.lock();
            }
        }

        public Post hentPost(String mottaker){
            laas.lock();
            try {
                if (stoerrelse() == 0){
                    ingenPost.await();
                }
                for (int i = 0; i < postArray.length; i++){
                    if (postArray[i] != null){
                        if (postArray[i].hentMottaker().equals(mottaker));
                        Post post = postArray[i];
                        postArray[i] = null; //fjerner hentet post ved å sette den til null
                        fullPost.signal(); //gir beskjed til andre tråder at posten ikke er full lenger
                        return post;
                    }
                } ingenPost.await();

            } catch (InterruptedException e){
                System.out.println("Ikke hent post.");
            } finally {
                laas.unlock();
            }
            return null;
        }

    }
}


