A stupid little game that will play itself with a few interactions every few minutes.

Code ex 1.
   <VBox>
      <Label
          text="------------------------------"
          />
      <HBox>
          <Label
              text="1"
              fx:id="noOfClickers"
              />
          <Label
              text=" Clickers"
              />
      </HBox>
      <HBox>
          <Label
              text="1"
              fx:id="clickerPPC"
              />
          <Label
              text=" Points per click"
              />
      </HBox>
      <HBox>
          <Label
              text="Purchase Cost: "
              />
          <Label
              text="5"
              fx:id="purchasePriceClicker"
              />
      </HBox>
      <Button
          text="Purchase"
          onAction="#purchaseClicker"
          />
   </VBox>
        
Used FXML to create all the guis with a controller to assign the logic to all the clicks and everything else.

Code ex 2.
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
      
