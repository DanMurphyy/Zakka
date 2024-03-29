package com.hfad.zakovatuz.manager

import com.hfad.zakovatuz.model.Question

object QuestionManager {

    val levelZeroQuestions: List<Question> = listOf(
        Question(
            text = "Bu dunyoda bir daraxt bor. Bu daraxtni mevasini Jannatda ham payg’ambarlar yeb do’st tutishadi. Bu daraxt nima?",
            answers = listOf("Xurmo", "Anjir", "Anor", "Uzum")),
        Question(text = "Bu dunyoda ikki narsa bor. To qiyomatgacha biri qochadi, biri esa quvadi. Bu narsa nima?",
            answers = listOf("Tun va Kun", "Oy va Quyosh", "Suv va Yer", "Yoshlik va Keksalik")),
        Question(text = "Asadulloh (Allohniung sheri) laqabli paxlavon sahobiy kim edi?",
            answers = listOf("Hamza r.a.", "Zubair r.a.", " Holid r.a.", "Ali r.a.")),
        Question(text = "Rasululloh s.a.v.ga farz bo’lgan, ummatlariga esa sunnat bo’lgan amal qaysi?",
            answers = listOf("Misvok ishlatish", "Taroveh", "Nikohlanish", "Kumush taqish")),
        Question(text = "Ka’ba atrofida yetti marta aylanib, ibodat qilishga nima deyiladi?",
            answers = listOf("Tavof", "Sayir", "Talbiya", "Qurbonlik")),
        Question(text = "Rasuluoh SAV va u zotning do’stlari Makkada kimning uyida yashirincha to’planardilar?",
            answers = listOf("Arqam r.a.ning ",
                "Ja'far r.a.ning",
                "Abu Salama r.a.ning",
                "Ammor r.a.ning")),
        Question(text = "Algebra atamasiga kim asos solgan?",
            answers = listOf("Al-Xorazmiy", "Ibn Sino", "Beruniy", "Farg'oniy")),
        Question(text = "Islomiy ramz sifatida hiloldan foydalanish kimlardan tarfidan boshlangan?",
            answers = listOf("Usmoniylar", "Temuriylar", "Abbosiylar", "Ummaviylar")),
        Question(text = "Islom olamida Andalusiya deb qayerni aytishadi?",
            answers = listOf("Portugaliya va Ispaniya",
                "Fransiya va Germaniya",
                "Italiya va Turkiya",
                "Suriya va Iroq")),
        Question(text = "Joni va boshi yo’q,lekin yemish yeydi. Bu narsa nima edi?",
            answers = listOf("Muso a.s.ning asolari",
                " Vaqt",
                "Solih a.s.ning tuyalari",
                "Yunus a.s.ning kiti")),
    )


    val level1Questions: MutableList<Question> = mutableListOf(
        Question(text = " Andalusiyani fath qilgan buyuk fotih, musulmon sarkarda kim?",
            answers = listOf("Jabal ibn Toriq",
                "Salohiddin Ayyubiy",
                "Fotih Mehmet Ikkinchi",
                "Xolid Ibn Valid r.a")),
        Question(text = "Islom olamida ushbu insonning janozasiga eng ko’p odam yig’ilgan(1.000.000 dan ziyod).Ushbu buyuk inson kim?",
            answers = listOf("Ahmad ibn Hanbal r",
                "Molik ibn Anas r",
                "Abu Hanifa r",
                "Shofeiy r")),
        Question(text = "Konstantinopol (Istanbul)ni fath qilgan musulmon fotihi kim?",
            answers = listOf("Fotih Mehmet Ikkinchi",
                "Jabal ibn Toriq",
                "Salohiddin Ayyubiy",
                "Boyazid Ikkinchi")),
        Question(text = "Qur’onda har bir surani o’qishdan avval Allohni ismi zikr qilinadi lekin bir sura bor uni o’qishdan avval Allohning Rahmon va Rahimlik sifatlari tilga olinmaslik kerak bu qaysi sura?",
            answers = listOf("Tavba surasi", "Masad surasi", "Nos surasi", "Fotiha surasi")),
        Question(text = "Islom olamida pochtani tashkil qilgan sahobiy kim?",
            answers = listOf("Hazrati Umar r.a.", "Abu Ubayda r.a.", "Ammor r.a.", "Hamza r.a.")),
        Question(text = "Islom tarixida aholini birinchi marta ro’yxatga olgan shaxs kim?",
            answers = listOf("Umar ibn Hattob r.a.", "Abu Bakr r.a.", "Arqam r.a.", "Ali r.a.")),
        Question(text = "Imom Buxoriyning \"Sahihul Buxoriy\" kitobidagi bir hadisda bayon etilishicha, paygambarlarning hammalari qaysi hunar(kasb) bilan shug’ullanishgan?",
            answers = listOf("Cho’ponlik", "Duradgor", "Dehqonchilik", "Savdogarlik")),
        Question(text = "Halifalar ichida eng ko’p halifalik qilgani kim?",
            answers = listOf("Hazrati Usmon ra.",
                "Umar ibn Hattob r.a.",
                "Abu Bakr r.a.",
                "Ali r.a.")),
        Question(text = "Rasululloh SAV mol-mulki ko’payishini duo qilib, bashorat bergan, vafot etganda, tort xotinining har biriga sakson ming dinordan meros tekkan sahoba kim edi?",
            answers = listOf("Abdurahmon ibn Avf r.a.",
                "Abu Bakr r.a.",
                "Bilol r.a.",
                "Tolha r.a.")),
        Question(text = " Quddusni fath qilgan Salohiddin Ayyubiyning millati nima edi?",
            answers = listOf("Kurd", "Arab", "Turk", "Fors")),
    )

    val level2Questions: MutableList<Question> = mutableListOf(
        Question(text = "Bir ulug’ sahobiy shahodat kalimasini keltirganlarida Rasululloh s.a.v: \"Sening aqlingni ko’rib ,bu aql faqat yahshilikka olib boradi, deb umid qilgan edim\", deganlar. Rasululloh s.a.v. bu muborak lafzlarini qaysi sahobiyga qarata aytganlar?",
            answers = listOf("Xolid ibn Valid r.a. ga",
                "Amr ibn Al os r.a. ga",
                "Bilol ibn Raboh r.a. ga",
                "Nuaym ibn Abdulloh r.a. ga")),
        Question(text = "Baytullohni 8-marta qayta qurilishida Rasululloh s.a.v. necha yoshda bo’lganlar?",
            answers = listOf("35", "45", "25", "30")),
        Question(text = "Badr g’azoti qaysi oyda bo’lgan edi?",
            answers = listOf("Ramazon", "Safar", "Muharram", "Shavval")),
        Question(text = "Xaybar g’zaotida Rasululloh SAV: \"Ertaga bayroqni shunday bir odamga tutqazamanki, u xudo bilan paygambarni jon-dildan sevadi. Bunday odamni Olloh bilan paygambar ham yaxshi koradi\", dedilar. Muhojirlar bilan ansorlar osha suyukli kishi ozlari bolib chiqishini orzu qildilar. Ertasi kuni Rasululloh bayroqni kimga topshiradilar?",
            answers = listOf("Ali ibn Abu Tolib r.a.",
                "Umar ibn Hattob r.a.",
                "Amr ibn Al os r.a.",
                "Ubayda ibn Horis r.a.")),
        Question(text = "Payg’ambarimizning SAV sirlarini Sohibi deb nom olgan sahoba kim ?",
            answers = listOf("Huzayfa ibn Yamon r.a. ",
                "Ammor ibn Yosir r.a.",
                "Abdulloh ibn Ma'sud r.a.",
                " Zubayr ibn Avvom r.a.")),
        Question(text = "Qaysi sura \"Ummul qur’on\" deya sharaflanadi?",
            answers = listOf("Fotiha", "Baqara", "Ihlos", "Mulk")),
        Question(text = "Islom tarixida birinchi Armiyani tuzgan va harbiy xizmatdagilarga maosh belgilagan shaxs kim?",
            answers = listOf("Umar ibn Hattob r.a.",
                "Xolid ibn Valid r.a. ga",
                "Amr ibn Al os r.a. ga",
                "Zubayr ibn Avvom r.a.")),
        Question(text = " Qur’oni karimda qaysi payg‘ambar haqidagi qissa faqat bitta surada hikoya qilinadi va boshqa suralarda uchramaydi?",
            answers = listOf("Yusuf a.s.", "Iso a.s.", "Odam a.s.", "Yunus a.s.")),
        Question(text = "Payg’ambarimizning SAV ilk bino etgan masjid qaysi?",
            answers = listOf("Qubo masjidi", "Aqso masjidi", "Masjid An Nabaviy", "AlHaram")),
        Question(text = "Payg’ambarimiz Muhammad SAV hadislarida ta’kidlangan \"Ozi halol-u, lekin Allohga eng yomon korilgan narsa\" nima?",
            answers = listOf("Taloq", "Qarz", "Yolg'on", "Vada")),
    )

    val level3Questions: MutableList<Question> = mutableListOf(
        Question(text = "Ma’lumki Payg’ambarimiz s.a.v ayollarni uyda o’qilgan namozlarini afzal deb marhamat qilganlar lekin bir namozda ayollarni erkaklar orqasida turib o’qishlikka buyurganlar. Bu qaysi namoz?",
            answers = listOf("Hayit namozlari",
                "Juma namozlari",
                "Taroveh namozlari",
                "Janoza namozlari")),
        Question(text = "Muhojirlar orasida Madinada tug’ilgan birinchi chaqaloq kim?",
            answers = listOf("Abdulloh ibn Zubayr r.a",
                "Abdulloh ibn Umar r.a",
                "Abdulloh ibn Mas'un r.a",
                "Abdulloh ibn Mas'ud r.a.")),
        Question(text = "Rasululloh s.a.v:\"... qiyomat kuni ulamolarning imomi bo’ladi’, deganlar. Bu sahobiy kim?",
            answers = listOf("Muoz ibn Jabal r.a.",
                "Qudoma ibn Maz'un r.a.",
                "Ja'far ibn Abu Tolib r.a.",
                "Said ibn Zaid r.a.")),
        Question(text = "Rasululloh s.a.v.ga farz hisoblangan, biz ummatlariga esa sunnat hisoblangan namoz qaysi?",
            answers = listOf("Tahajjud namozi",
                "Juma namozlari",
                "Taroveh namozlari",
                "Janoza namozlari")),
        Question(text = "Rasululloh SAV qatnashgan eng so’nggi g’azot qaysi edi?",
            answers = listOf("Tabuk g’azoti", "Makka Fathi", "Badr g’azoti", "Xandoq g’azoti")),
        Question(text = "Rasululloh s.a.v.ning eng sevikli farzandlari, Ali r.a. zavjalari, Imom Hasan va Shahidlar Sultoni deb ta’riflangan Imom Husaynning onasi bo’lgan Forima r.a. necha yoshlarida vafot etganlar?",
            answers = listOf("29 yosh", "20 yosh", "63 yosh", "35 yosh")),
        Question(text = "Shunday amal borki insonlar uchun juda qiyin ko’rinadi lekin Ibn Sirriyn uni juda oson deb tariflagan osonligi shundaki shubhani tark etish bilan u amalga erishish mumkin u qanday amal?",
            answers = listOf("Taqvo", "Namoz", "Lavz", "Yolg'on")),
        Question(text = "\"Harsanglarni toshlarni ko’tardim lekin.....ko’ra og’irroq narsani ko’rmadim\" Ali ibn abu Tolib. Ali raziyallohuga ogirlik qilgan narsa nima?",
            answers = listOf("Qarz", "Ilm", "Taqvo", "Lavz")),
        Question(text = "Hijrat chog’ida Payg’ambarimiz Muhammad sallollohu alayhi va sallam va Abu Bakr Siddiq tunagan g’orning nomi nima?",
            answers = listOf("Savr g’ori", "Hiro g’ori", "Arafat g’ori", "As'hobi Kehf g’ori")),
        Question(text = "Misrni fath etgan Islom sarkardasi kim?",
            answers = listOf("Amr Ibn Os r.a.",
                "Miqdod ibn Asvad r.a.",
                "Umar ibn Hattob r.a.",
                "Xolid ibn Volid r.a.")),
        Question(text = "Salmon Forsiy r.a. qaysi halifa davrida vafot etganlar?",
            answers = listOf("Usmon (r.a) davrida",
                "Abu Bakr (r.a) davrida",
                "Ali (r.a) davrida",
                "Umar (r.a) davrida")),
        Question(text = "Rasululloh s.a.v. sahobiylariga bir so’zni aytishni ma’n qilganlar. Va bu so’zga ojizlik belgisi deya ta’rif berganlar. Bu so’z qaysi?",
            answers = listOf("Agar", "Kech", "Ertaga", "Bilmayman")),
        Question(text = "Isfahonning Jabbon deb ataladigan qishlog‘ida tug'ilgan sahoba?",
            answers = listOf("Salmon Forsiy r.a.",
                "Abdulloh ibn Jaxsh r.a.",
                "Tulaib ibn Umar r.a.",
                "Utba ibn G'azvon r.a.")),
        Question(text = "Rasululloh s.a.v.dedilar: \"Bu yigit menga tog’a bo’ladi, yana kim menga o’z tog’asini ko’rsatadi?\" Rasululloh s.a.v.ga \"tog’a\" bo’lgan sahobiy kim?",
            answers = listOf("Sa’d Ibn Abu Vaqqos r.a.",
                "Ja'far ibn Abu Tolib r.a.",
                "Ali ibn Abu Tolib r.a.",
                "Hamza ibn Abdul Muttolib r.a.")),
    )

    val level4Question: MutableList<Question> = mutableListOf(
        Question(text = "Imom Muslim tug’ilgan shaharning nomi?",
            answers = listOf("Nishopur", "Madina", "Qohira", "Bog'dod")),
        Question(text = "Rasulullohning s.a.v. onalari vafot etganlarida bir dodaklarini (cho’rilarini) qo’lida qolganlar. Bu cho’rilarini ismi nima edi?",
            answers = listOf("Ummu Ayman r.a.", "Ummu Salama r.a.", "Sumayya r.a.", "Atiqa r.a.")),
        Question(text = "Madinaga birinchi bo’lib hijrat qilishga chiqqan sahoba kim?",
            answers = listOf("Abu Salama r.a.",
                "Usmon ibn Affon r.a.",
                "Tolha ibn Ubaydulloh r.a.",
                "Bilol ibn Raboh r.a.")),
        Question(text = "Badr g’azotida musulmonlar bayrog’ini kim ko’targan edi?",
            answers = listOf("Musab ibn Umayr r.a",
                "Abu Ubayda ibn Jarroh r.a.",
                "Abu Bakr r.a.",
                "Habbob ibn Arat r.a.")),
        Question(text = "Badr g’azotida musulmonlardan necha kishi shahid bo’lgan edi?",
            answers = listOf("14", "70", "5", "30")),
        Question(text = "Rasululloh s.a.v. bir sahobiyga: \"Ummatim orasida halol va haromni eng yahshi biluvchi inson’,-deya ta’rif berganlar. Bu sahobiy kim edi?",
            answers = listOf("Muoz ibn Jabal r.a.",
                "Umar ibn Hattob r.a.",
                "Said ibn Zayd r.a.",
                "Ali ibn Abu Tolib r.a.")),
        Question(text = "Rasululloh s.a.v: \"Kim jang qilmoqchi bo’lsa ... kabi jang qilsin\", deganlar. Bu sahobiy kim?",
            answers = listOf("Osim ibn Sobit r.a. ",
                "Ali ibn Abu Tolib r.a.",
                "Hamza r.a.",
                "Zubayr ibn Avvom r.a.")),
        Question(text = "Islomda birinchi kamon otgan sahobiy kim?",
            answers = listOf("Sa’d ibn Abu Vaqqos r.a.",
                "Ammor ibn Yosir r.a.",
                "Musab ibn Umair r.a.",
                "Hamza ibn Abdil Muttolib r.a.")),
        Question(text = "Rasululloh \"... o‘lganida (uni ruh’i kelayotganini farishtalarga ma’lum qilish uchun) Arsh (shodiyona) bir tebranib qo‘ydi\" deb qaysi sahoba haqida aytganlar?",
            answers = listOf("Sa'd ibn Muoz r.a.",
                " Hamza ibn Abdil Muttolib r.a. ",
                "Ja'far ibn Abu Tolib r.a.",
                "Ubayda ibn Horis r.a.")),
        Question(text = "Rasululloh u sahobiyni juda yaxshi ko‘rganlaridan, u sahobiy \"Rasulullohning mahbubi\" laqabini olgan edi. U kim?",
            answers = listOf("Zayd ibn Horisa r.a",
                "Ali ibn Abu Tolib r.a.",
                "Anas ibn Molik r.a.",
                "Huzayfa r.a.")),
        Question(text = "Ilk marta \"Arba’in hadis\"(40 talik hadis) kitobini kim yozgan?",
            answers = listOf("Abdulloh ibn Muborak al-Marvaziy r.",
                "Imom AnNavaviy r.",
                "Izz ibn Abdussalam r.",
                "Lays ibn Saad r.")),
        Question(text = "Shahid bo’lgandang so’ng farishtalar yuvgan sahobiy kim?",
            answers = listOf("Hanzala r.a", "Hamza r.a", "Sa'd r.a", "Ja'far r.a")),
        Question(text = " Paygambarimiz (s.a.v) ning davrlarida paygambarlik da’vo qilgan kishi kim?",
            answers = listOf("Musaylama kazzob", "Abu Lahab", "Abu Jahl", " Volid ibn Mug'iyra")),
    )
}