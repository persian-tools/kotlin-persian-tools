<div align="center">
	<p align="center">
		<img src="https://raw.githubusercontent.com/persian-tools/persian-tools/master/images/logo.png" width="200" />
	</p>
	<h1 align="center">Persian tools</h1>
    <hr/>
    <p align="center">Persian Tools Kotlin package which you can use in all platforms</p>

[![MIT license](https://img.shields.io/badge/License-MIT-blueviolet)](https://github.com/persian-tools/kotlin-persian-tools/blob/master/LICENSE)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.4.32-blueviolet)](https://kotlinlang.org/)
![status](https://img.shields.io/badge/Status-Under%20development-blueviolet)
</div>
<hr/>

## Features
- [x] Ordinal suffixes(add/remove)
- [ ] Converting Persian words to number
- [ ] Converting Persian numbers to word
- [ ] Adding and removing separator to/from numbers
- [ ] Converting Persian numbers to Arabic / English numbers and reverse
- [ ] Validating Iranians national id
- [ ] Finding city and province names by national id
- [x] Calculating bills
- [ ] Checking validation of IBAN (_SHEBA_)
- [ ] Recognizing bank information by IBAN (_SHEBA_)
- [ ] Validating ATM card number
- [ ] Finding name of banks by ATM card number
- [ ] Getting information from vehicle plate

## Usage

### Ordinal suffixes

- #### Add ordinal suffix:
  ```kotlin
  "پنجاه سه".addOrdinalSuffix() //will return پنجاه سوم
  
  val number = "ده"
  
  number.addOrdinalSuffix() // will return دهم

  //or:
  
  OrdinalSuffix.addOrdinalSuffix("سی دو") //will return سی دوم
  ```
  
- #### Remove ordinal suffix:

  ```kotlin
  "پنجاه سوم".removeOrdinalSuffix() //will return پنجاه سه
  
  val number = "دهم"
  
  number.removeOrdinalSuffix() // will return ده

  //or:
  
  OrdinalSuffix.removeOrdinalSuffix("سی دوم") //will return سی دو
  ```

### Calculating Bills

**_Usage:_**
```kotlin
val bill = Bill(
  billId = billId,
  paymentId = paymentId,
  currency = BillCurrency.RIAL
)


bill.amount() //calculate amount of bill based on the currency

bill.type() //get the BillType

bill.barcode() //get the barcode String
//Validations:
bill.isValidBillId()
bill.isValidBillPayment()
bill.isValid()
```
_Just have the barcode string? find `BillID` and `PaymentID`:_

```kotlin
val (billId, paymentId) = Bill.findByBarcode(barcode)
```