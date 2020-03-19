# DataDriven-AndroidStudio
Mobile App test dengan Data Driven

```diff
* SYARAT
- Kalian Harus Paham Dengan Espresso Android Test (kalau belum paham harus dipelajari terlebih dahulu)
```



Pembuatan :
- buat folder raw di dalam folder res
- buat file baru dengan nama "data.csv" di dalam folder raw tersebut

![Jython Success](https://raw.githubusercontent.com/asengsaragih/DataDriven-AndroidStudio/master/screenshoot/ss-1.PNG?token=ALYLNT3CRVP7B4T6AJUI3TS6PQ3BK)

- isi data sesuai dengan banyaknya inputan yang dimiliki. disini saya memakai 4 inputan (text, number, date dan radio-button), dengan 7 data, sesuai dengan yang ada di "data.csv"

![Jython Success](https://raw.githubusercontent.com/asengsaragih/DataDriven-AndroidStudio/master/screenshoot/ss-3.PNG?token=ALYLNT3HPNKXCKOTZJ2JGCK6PQ3PM)

- lalu buat file andorid test dan kasih nama "DataDriven.java" (nama file bisa diganti sesuai dengan yang kalian inginkan)

![Jython Success](https://raw.githubusercontent.com/asengsaragih/DataDriven-AndroidStudio/master/screenshoot/ss-2.PNG?token=ALYLNT2BDEJQEG5HRZIKUXK6PQ36O)

- buat sebuah function di akhir file, yang berfungsi sebagai pemanggil file csv

```java
private InputStream openFile(String filename) throws IOException {
    return getClass().getClassLoader().getResourceAsStream(filename);
}
```

- dan panggil function nya

```java
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFile("data.csv")));
```

- masukkan kedalam perulangan while

```java
String line = "";

while ((line = bufferedReader.readLine()) != null) {
  String[] str = line.split(",");

  String create = str[0].toString();
  String nama = str[1].toString();
  String jumlah = str[2].toString();
  String phone = str[3].toString();
  String deadline = str[4].toString();
  String keterangan = str[5].toString();
  String kategori = str[6].toString();
  
}
```

- Masukkan datanya kedalam onView();





Note :
- Jangan lupa ganti script "Example.java" sesuai dengan kodingan / tampilan kalian

Terima Kasih

Copyright Aseng Saragih 2020
