# Generating SDP/SSP
## Based on 360dp

* For apps only for phones, then only take out those phone width in dp as targets
* Because most of phones are in 360dp width, and designer picked 360dp as a baseline
* Same logic based on: [SDP - a scalable size unit](https://github.com/intuit/sdp)

Reference: [Devices Metrics](https://material.io/tools/devices/)

Devices Metrics in px:

|Material         |ldpi     |mdpi     |hdpi    |xhdpi    |xxhdpi    |xxxhdpi  | 
|-----------------|---------|--------|---------|---------|----------|---------|
|Launcher And Home|36*36    |48*48   |72*72    |96*96    |144*144   |192*192  |
|Toolbar And Tab  |24*24    |32*32   |48*48    |64*64    |96*96     |128*128  |
|Notification     |18*18    |24*24   |36*36    |48*48    |72*72     |96*96    |
|Background       |240*320  |320*480 |480*800  |768*1280 |1080 *1920|1440*2560|
