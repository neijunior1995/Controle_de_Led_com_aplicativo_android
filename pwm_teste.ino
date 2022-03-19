int D5 = 14;
int D6 = 12;
int D7 = 13;
int intensidadeRed = 0;
int intensidadeGreen = 50;
int intensidadeBlue = 100;
void setup() {
  pinMode(D5,OUTPUT);
  pinMode(D6,OUTPUT);
  pinMode(D7,OUTPUT);
  //analogWriteRange(new_range);
  analogWriteFreq(10000);

}


void loop() {
   if (intensidadeRed <= 255){
    intensidadeRed++;
    }
   else{
    intensidadeRed = 0;
     }
   analogWrite(D5,intensidadeRed);
   if (intensidadeGreen <= 255){
    intensidadeGreen++;
    }
   else{
    intensidadeGreen = 0;
     }
   analogWrite(D6,intensidadeGreen);
   if (intensidadeBlue <= 255){
    intensidadeBlue++;
    }
   else{
    intensidadeBlue = 0;
     }
   analogWrite(D7,intensidadeBlue);
   delay(50);
   
}
