Year 

SELECT serviceTo, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice 
    WHERE serviceFrom >= '?-07-01' AND serviceTo <= '?-06-30';

SELECT accountNum, serviceTo, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice 
    WHERE accountNum = ? AND serviceFrom >= '?-07-01' AND serviceTo <= '?-06-30';

SELECT serviceTo, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice
    WHERE strftime(“%m”, serviceFrom) = ? AND strftime(“%Y”, serviceFrom) = ?;

SELECT serviceTo, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice WHERE serviceFrom >= 2017-07-01 AND serviceFrom <= 2018-06-30;

SELECT serviceFrom, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice WHERE serviceFrom >= '2017-07-01' AND serviceFrom <= '2018-06-30';

SELECT serviceFrom, sum(billingUnits*748) AS gallons, sum(totalCharges) FROM Invoice WHERE strftime(“%m”, serviceFrom) = 07;