package com.hfad.zakovatuz

data class Question(
    val text: String,
    val answers: List<String>)

// The first answer is the correct one.  We randomize the answers before showing the text.
// All questions must have four answers.  We'd want these to contain references to string
// resources so we could internationalize. (or better yet, not define the questions in code...)
val questions: MutableList<Question> = mutableListOf(
    Question(text = "Bu dunyoda bir daraxt bor. Bu daraxtni mevasini Jannatda ham payg’ambarlar yeb do’st tutishadi. Bu daraxt nima?",
        answers = listOf("Xurmo","Anjir","Anor","Uzum")),
    Question(text = "Bu dunyoda ikki narsa bor. To qiyomatgacha biri qochadi, biri esa quvadi. Bu narsa nima?",
        answers = listOf("Tun va Kun","Oy va Quyosh","Suv va Yer","Yoshlik va Keksalik")),
    Question(text = "Asadulloh (Allohniung sheri) laqabli paxlavon sahobiy kim edi?",
        answers = listOf("Hamza r.a.","Zubair r.a."," Holid r.a.","Ali r.a.")),
    Question(text = "Rasululloh s.a.v.ga farz bo’lgan, ummatlariga esa sunnat bo’lgan amal qaysi?",
        answers = listOf("Misvok ishlatish","Taroveh","Nikohlanish","Kumush taqish")),
    Question(text = "Ka’ba atrofida yetti marta aylanib, ibodat qilishga nima deyiladi?",
        answers = listOf("Tavof","Sayir","Talbiya","Qurbonlik")),
    Question(text = "Rasuluoh SAV va u zotning do’stlari Makkada kimning uyida yashirincha to’planardilar?",
        answers = listOf("Arqam r.a.ning ","Ja'far r.a.ning","Abu Salama r.a.ning","Ammor r.a.ning")),
    Question(text = "Algebra atamasiga kim asos solgan?",
        answers = listOf("Al-Xorazmiy","Ibn Sino","Beruniy","Farg'oniy")),
    Question(text = "Islomiy ramz sifatida hiloldan foydalanish kimlardan tarfidan boshlangan?",
        answers = listOf("Usmoniylar","Temuriylar","Abbosiylar","Ummaviylar")),
    Question(text = "Islom olamida Andalusiya deb qayerni aytishadi?",
        answers = listOf("Portugaliya va Ispaniya","Fransiya va Germaniya","Italiya va Turkiya","Suriya va Iroq")),
    Question(text = "Joni va boshi yo’q,lekin yemish yeydi. Bu narsa nima edi?",
        answers = listOf("Muso a.s.ning asolari"," Vaqt","Solih a.s.ning tuyalari","Yunus a.s.ning kiti")),
    )



