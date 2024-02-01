
class Postmann implements Runnable{

    Post.Postkontor postkontor;
    Postmann(Post.Postkontor postkontor){
        this.postkontor = postkontor;
    
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            if ( i % 2 == 0){  // har to kunder som står i kø
                Post nyPost = new Post("hei, pakken din er klar for henting", "Tommy");
                postkontor.leverPost(nyPost);
            } else{
                Post nyPost = new Post("hei, pakken din er klar for henitng", "Mina");
                postkontor.leverPost(nyPost);

            }
        }
    }
}
