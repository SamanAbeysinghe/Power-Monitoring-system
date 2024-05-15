#include <EmonLib.h>
EnergyMonitor emon1;

void setup() {
  Serial.begin(9600);
  double voltageCalibration = 230.0; 
  double currentCalibration = 30.0; 
  
  emon1.voltage(34, voltageCalibration, 1.7);    
  emon1.current(35, currentCalibration);     
}
void loop() {
  double voltage = emon1.calcVI(20, 200);    
  double current = emon1.calcIrms(1480);    
  double power = voltage * current;         

  Serial.print("Voltage: ");
  Serial.print(voltage);
  Serial.print(" V\t");

  Serial.print("Current: ");
  Serial.print(current);
  Serial.print(" A\t");

  Serial.print("Power: ");
  Serial.print(power);
  Serial.println(" W");

  delay(1000);
}
