# DOMAIN LOGIC AND DATA SOURCE
Domain logic basically describes the functional algorithms or business logic that handle the information exchange between a database and a UI. The commonly used approaches are :
1. Transaction Script
2. Domain Model
3. Table Module.

The first two of the approaches are implemented in this repository using RevenueRecognitionService. 

Problem Space:
Imagine a company selling software products of three different types such as Photo Editing Software (PHOTOEDIT), Vector Drawing Software (DRAWVECTOR) and Video Editing Software (VIDEOEDIT).
The revenue obtained from these products are not straight forward as if you don’t get the entire revenue at one shot as the customers purchase.
The problem specified in this example, If the software is of type 1 i.e. Photo Editing Software (PHOTOEDIT), You get the revenue at once.
Else, if it is of type 2 i.e. Vector Drawing Software (DRAWVECTOR), you get 1/3 of the total revenue as they purchase, the next 1/3 after 30 days and final 1/3 after 90 days.
And, if it is of type  i.e. Video Editing Software (VIDEOEDIT), you get 1/3 of the total revenue as they purchase, the next 1/3 after 60 days and final 1/3 after another 60 days.

This problem is well explained using the both approaches separately. 

The UI lets you add a contract based on the type of product you purchase along with the date you sign. 
Then after a specified period of time, the revenue is calculated according to the above business logic and return on a particular date is displayed. 
The sample interfaces are as follows:

### Add Contract Portal
![](https://github.com/FathimaShafana/SAD/blob/main/DomainLogic/Screenshots/AddContract.JPG?raw=true)
![](https://github.com/FathimaShafana/SAD/blob/main/DomainLogic/Screenshots/typeVideoEdit.JPG?raw=true)

### Check Revenue Recognition
![](https://github.com/FathimaShafana/SAD/blob/main/DomainLogic/Screenshots/RevenueID3.JPG?raw=true)

### Various Revenue Recognized based on date and type
![](https://github.com/FathimaShafana/SAD/blob/main/DomainLogic/Screenshots/ID3.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/DomainLogic/Screenshots/showRR2.JPG?raw=true)
