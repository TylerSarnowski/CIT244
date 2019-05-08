A stupid little game that will play itself with a few interactions every few minutes.
Code ex 1.
   private void startTask() {
       Runnable task = () -> runTask();
       Thread backgroundThread = new Thread(task);
       backgroundThread.setDaemon(true);
       backgroundThread.start();
   }

   private void runTask(){
       while(true){
           try{
               Platform.runLater(() -> {
                   points += (valueGenerator + valueFarm + valueFactory);
                   setText(totalPoints,points);
               });
               sleep(sleepTime / timeWarp);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
These blocks of code are used to control the multithreading with the ability to activly update the gui 
      
