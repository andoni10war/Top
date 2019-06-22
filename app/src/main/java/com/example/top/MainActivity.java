package com.example.top;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;

    private ArtistaAdapter adapter;

    public static final  Artista sArtista = new Artista();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configToolbar();
        configAdapter();
        configRecyclerView();

        generateArtist();


    }

    private void generateArtist() {
        String[] nombres = {"Rachel", "Naomi", "Keanu"};
        String[] apellidos = {"McAdams", "Scott", "Reeves"};
        long[] nacimientos = {280108800000l, 736646400000l, -168220800000l};
        String[] lugares = {"London,Ontario,Canada", "London,England", "Beirut, Lebanon"};
        short[] estaturas = {163, 167, 186};
        String[] notas = {"Rachel Anne McAdams was born on November 17, 1978 in London, Ontario, Canada, to Sandra Kay (Gale), a nurse, and Lance Frederick McAdams, a truck driver and furniture mover. She is of English, Welsh, Irish, and Scottish descent. Rachel became involved with acting as a teenager and by the age of 13 was performing in Shakespearean productions in summer theater camp; she went on to graduate with honors with a BFA degree in Theater from York University. After her debut in an episode of Disney's The Famous Jett Jackson (1998), she co-starred in the Canadian TV series Slings and Arrows (2003), a comedy-drama about the trials and travails of a Shakespearean theater group, and won a Gemini award for her performance in 2003.\n" +
                "\n" +
                "Her breakout role as Regina George in the hit comedy Chicas malas (2004) instantly catapulted her onto the short list of Hollywood's hottest young actresses. She followed that film with a star turn opposite Ryan Gosling in the adaptation of the Nicholas Sparks bestseller El diario de Noa (2004), which was a surprise box office success and became the predominant romantic drama for a new, young generation of moviegoers. After filming, McAdams and Gosling became romantically involved and dated through mid-2007. McAdams next showcased her versatility onscreen with the manic comedy De boda en boda (2005), the thriller Vuelo nocturno (2005), and the holiday drama La joya de la familia (2005).\n" +
                "\n" +
                "McAdams then explored the independent film world with El juego del matrimonio (2007), which premiered at the Toronto Film Festival and also starred Pierce Brosnan, Chris Cooper and Patricia Clarkson. Starring roles in the military drama Tipos con suerte (2008), the newspaper thriller La sombra del poder (2009), and the romance Más allá del tiempo (2009) followed before she starred opposite Robert Downey Jr. and Jude Law in Guy Ritchie's international blockbuster Sherlock Holmes (2009). McAdams played the plucky producer of a failing morning TV show in Morning Glory (2010), the materialistic fiancée of Owen Wilson in Woody Allen's Midnight in Paris (2011), and returned to romantic drama territory with the hit film Todos los días de mi vida (2012) opposite Channing Tatum. The actress also stars with Ben Affleck in Terrence Malick's To the Wonder (2012) and alongside Noomi Rapace in Brian De Palma's thriller Passion (2012).\n" +
                "\n" +
                "In 2005, McAdams received ShoWest's \"Supporting Actress of the Year\" Award as well as the \"Breakthrough Actress of the Year\" at the Hollywood Film Awards. In 2009, she was awarded with ShoWest's \"Female Star of the Year.\" As of 2011, she has been romantically linked with her Midnight in Paris (2011) co-star Michael Sheen.",
                "Naomi Scott is a multi-talented actor, singer and songwriter. She can next be seen starring as \"Jasmine\" in Disney's live-action remake of \"Aladdin,\" alongside Will Smith, directed by Guy Ritchie. Disney will release the film in May 2019.\n" +
                        "\n" +
                        "Naomi was born in London, England, to Usha (Joshi) and Christopher Scott, who are pastors of the Bridge Church, Woodford in Redbridge. Her father is British and her mother, who is from Uganda, is from a Gujarati Indian family.\n" +
                        "\n" +
                        "Naomi appeared in \"The 33,\" directed by Patricia Riggen. Starring Juliette Binoche, Gabriel Byrne and Antonio Banderas, the film is based on the 2010 rescue of 33 Chilean miners after being trapped for 69 days in a gold and copper mine. Naomi plays \"Escarlette\", the daughter of Banderas' character who is the leader of the miners. Additional credits include a series regular role in Steven Spielberg's television series \"Terra Nova\" for DreamWorks and FOX, a lead role in the hit Disney Channel movie \"Lemonade Mouth\" and a lead role in Lee Toland Krieger's short film \"Modern/Love\" produced by Roman Coppola.\n" +
                        "\n" +
                        "In 2017, Scott was seen in Lionsgate's \"Power Rangers,\" directed by Dean Israelite, which tells the story of a group of teenagers who transform into a uniformed team of superheroes ready to protect the world from evil. Naomi plays \"Kimberly\" aka 'The Pink Ranger', a girl unconventionally cool in a way all the popular girls wish they were.\n" +
                        "\n" +
                        "Naomi is in production on \"Charlie's Angels,\" which Elizabeth Banks is helming for Sony - she won the highly coveted leading role of \"Elena\" opposite Kristen Stewart. Sony is set to release the film in November 2019.",
                "Keanu Charles Reeves, whose first name means \"cool breeze over the mountains\" in Hawaiian, was born September 2, 1964 in Beirut, Lebanon. He is the son of Patricia Taylor, a showgirl and costume designer, and Samuel Nowlin Reeves, a geologist. Keanu's father was born in Hawaii, of British, Portuguese, Native Hawaiian, and Chinese ancestry, and Keanu's mother is originally from England. After his parents' marriage dissolved, Keanu moved with his mother and younger sister, Kim Reeves, to New York City, then Toronto. Stepfather #1 was Paul Aaron, a stage and film director - he and Patricia divorced within a year, after which she went on to marry (and divorce) rock promoter Robert Miller and hair salon owner Jack Bond. Reeves never reconnected with his biological father. In high school, Reeves was lukewarm toward academics but took a keen interest in ice hockey (as team goalie, he earned the nickname \"The Wall\") and drama. He eventually dropped out of school to pursue an acting career.\n" +
                        "\n" +
                        "After a few stage gigs and a handful of made-for-TV movies, he scored a supporting role in the Rob Lowe hockey flick Youngblood (Forja de campeón) (1986), which was filmed in Canada. Shortly after the production wrapped, Reeves packed his bags and headed for Hollywood. Reeves popped up on critics' radar with his performance in the dark adolescent drama, Instinto sádico (1986), and landed a supporting role in the Oscar-nominated Las amistades peligrosas (1988) with director Stephen Frears.\n" +
                        "\n" +
                        "His first popular success was the role of totally rad dude \"Ted Logan\" in Las alucinantes aventuras de Bill y Ted (1989). The wacky time-travel movie became something of a cultural phenomenon, and audiences would forever confuse Reeves's real-life persona with that of his doofy on-screen counterpart. He then joined the casts of Ron Howard's comedy, Dulce hogar... ¡a veces! (1989) and Lawrence Kasdan's Te amaré hasta que te mate (1990).\n" +
                        "\n" +
                        "Over the next few years, Reeves tried to shake the Ted stigma with a series of highbrow projects. He played a slumming rich boy opposite River Phoenix's narcoleptic male hustler in Mi Idaho privado (1991), an unlucky lawyer who stumbles into the vampire's lair in Drácula de Bram Stoker (1992), and Shakespearean party-pooper Don John in Mucho ruido y pocas nueces (1993).\n" +
                        "\n" +
                        "In 1994, the understated actor became a big-budget action star with the release of Speed - Máxima potencia (1994). Its success heralded an era of five years in which Reeves would alternate between small films, like Luna sin miel (1996) and La última vez que me suicidé (1997), and big films like Un paseo por las nubes (1995) and Pactar con el diablo (1997). (There were a couple misfires, too: Johnny Mnemonic (1995) and Reacción en cadena (1996).) After all this, Reeves did the unthinkable and passed on the Speed sequel, but he struck box-office gold again a few years later with the Wachowski siblings' cyberadventure, Matrix (1999).\n" +
                        "\n" +
                        "Now a bonafide box-office star, Keanu would appear in a string of smaller films -- among them Equipo a la fuerza (2000), Juego asesino (2000), Premonición (2000), Noviembre dulce (2001), and Hardball (2001) - before Matrix Reloaded (2003) and Matrix Revolutions (2003) were both released in 2003.\n" +
                        "\n" +
                        "Since the end of The Matrix trilogy, Keanu has divided his time between mainstream and indie fare, landing hits with Cuando menos te lo esperas (2003), La casa del lago (2006), and Dueños de la calle (2008). He's kept Matrix fans satiated with films such as Constantine (2005), A Scanner Darkly (2006), and Ultimátum a la Tierra (2008). And he's waded back into art-house territory with Ellie Parker (2005), Thumbsucker (2005), La vida privada de Pippa Lee (2009), and Henry's Crime (2010).\n" +
                        "\n" +
                        "Most recently, as post-production on the samurai epic La leyenda del samurái: 47 Ronin (2013) waged on, Keanu appeared in front of the camera in El impacto del cine digital (2012), a documentary on celluloid and digital filmmaking, which he also produced. He also directed another Asian-influenced project, El poder del Tai Chi (2013).\n" +
                        "\n" +
                        "In 2014, Keanu played the title role in the action revenge film John Wick (Otro día para matar) (2014), which became popular with critics and audiences alike. He reprised the role in John Wick: Pacto de sangre (2017), taking the now-iconic character to a better opening weekend and even more enthusiastic reviews than the first go-around."};
        String[] fotos = {"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Rachel_McAdams_3.jpg/751px-Rachel_McAdams_3.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/a/a5/Naomi_Scott.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/a/af/Keanu_Reeves_%2825448963336%29_%28cropped%29.jpg"};

        for (int i = 0; i < 3; i++) {
            Artista artista = new Artista(nombres[i], apellidos[i], nacimientos[i],
                    lugares[i], estaturas[i], notas[i], i + 1, fotos[i]);
            //adapter.add(artista);
            try {
                artista.save();
                Log.i("DBFlow", "Inserción correcta de datos");
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("DBFlow", "Error al insertar datos");
            }
        }
    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
    }

    private void configAdapter() {
        adapter = new ArtistaAdapter(new ArrayList<Artista>(), this);
    }

    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Metodos implementados por la interfaz OnItemClickListener
    @Override
    public void onItemClick(Artista artista) {
        sArtista.setId(artista.getId());
        sArtista.setNombre(artista.getNombre());
        sArtista.setApellidos(artista.getApellidos());
        sArtista.setFechaNacimiento(artista.getFechaNacimiento());
        sArtista.setEstatura(artista.getEstatura());
        sArtista.setLugarNacimiento(artista.getLugarNacimiento());
        sArtista.setOrden(artista.getOrden());
        sArtista.setNotas(artista.getNotas());
        sArtista.setFotoUrl(artista.getFotoUrl());

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLongItemClick(Artista artista) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == RESULT_OK && requestCode == 1){
            adapter.add(sArtista);
        }
    }
    @OnClick(R.id.fab)
    public void addArtist() {
        Intent intent = new Intent(MainActivity.this, AddArtistActivity.class);
        intent.putExtra(Artista.ORDEN, adapter.getItemCount()+1);
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }
}
