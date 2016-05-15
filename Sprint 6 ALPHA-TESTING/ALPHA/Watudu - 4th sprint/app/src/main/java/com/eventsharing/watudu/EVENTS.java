package com.eventsharing.watudu;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;

public class EVENTS extends Activity {

    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {"Subscribe to ACM", "Subscribe to Broad", "Subscribe to CS", "Subscribe to CS", "Subscribe to Rep", "Subscribe to Stat", "Subscribe to Tomo-Kai", "Subscribe to CE"};
    //STATIC PICTURES TO
    public static int[] prgmImages = {R.drawable.images, R.drawable.images1, R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images5, R.drawable.images6, R.drawable.images7};
    public static String[] prgmDesc = {"Be prepared as embark your journey into the Tech Industry. \n" +
            "\n" +
            "In partnership with UP Circuit and Accenture in the Philippines, we present you ACCELERATE. A talk by Accenture on the Critical Skills needed in the Tech Industry.\n" +
            "\n" +
            "Sign up at: http://goo.gl/forms/O2gGUsXeL2\n" +
            "\n" +
            "5.00-7.00 PM at the EEE LC1 this April 29 2016 Friday.\n" +
            "\n" +
            "See you there!\n", "Feed your minds and stomachs by joining us on April 28, Thursday, at the CMC Auditorium from 5:30-8:00 PM for a chance to be a part of the discussion and to win gift certificates from Max's Restaurant, Jamba Juice, Krispy Kreme, and Yellow Cab. Free food will also be served.\n" +
            "\n" +
            "Media Revolution 3.0 is brought to you by the UP Broadcasters' Guild, alongside the UP College of Mass Communication Administration.\n" +
            "\n" +
            "Together with our media partner:\n" +
            "Crossover FM\n" +
            "\n" +
            "Also brought to you by:\n" +
            "U.P. Cineastes' Studio\n" +
            "UP ASTRUM SCIENTIS Sorority\n" +
            "UP Samahan sa Agham Pampulitika\n" +
            "The UP Repertory Company\n" +
            "UP KAISA (K1)\n" +
            "UP Deutscher Verein\n" +
            "UP Le Club Français\n" +
            "\n" +
            "#MediaRev", "[The Great Space Race]\n" +
            "\n" +
            "Get ready as different challenges head your way. Form a group with your friends and prepare to solve challenges as you race with other teams to be the best! \n" +
            "\n" +
            "UP ACM presents The Great Space Race, an online capture the flag event which will test your knowledge and skills. \n" +
            "\n" +
            "Stay tuned for more updates!\n" +
            "\n" +
            "Register here: upacm-asr.cf/register\n" +
            "Rules: upacm-asr.cf/rules.", "Experience a new kind of universe.\n" +
            "\n" +
            "Department of Computer Science\n" +
            "Engineering Student Council\n" +
            "presents\n" +
            "SPACE BAR: CS Party 2016\n" +
            "\n" +
            "Together with\n" +
            "UP DCS Servers\n" +
            "UP Association for Computing Machinery (UP ACM)\n" +
            "UP Center for Student Innovations\n" +
            "UP Association of Computer Science Majors\n" +
            "The UP Parser\n" +
            "\n" +
            "In cooperation with ALN Group of Companies\n" +
            "\n" +
            "Special thanks to MobileMINDS Inc.\n" +
            "\n" +
            "With free flowing drinks, neon lights, and a wide range of party activities, SPACE BAR takes you to a whole new world this April 29 at 8/F Torre Venezia Suites, 170 Timog Ave., Quezon City.\n" +
            "\n" +
            "Doors open at 7:30 PM\n" +
            "\n" +
            "Get your tickets now at bit.ly/CSPartySpaceBar\n" +
            "\n" +
            "For inquiries, you may contact Abbey (0927 406 1944)\n", "The UP Repertory Company proudly presents the first part in the travelogue series, TERMINAL: SASAMA KA BA SA TRIP?\n" +
            "Sumama sa isang di-malilimutang araw sa buhay ni Gerry, sa pagtahak niya sa:\n" +
            "\n" +
            "ASSEMBLY LANE\n" +
            "Directed by Miguel Bongato\n" +
            "Written by Dominic Panaligan\n" +
            "\n" +
            "MAY 2 (6 PM & 8 PM)\n" +
            "For ticket reservations, contact 0906 692 5606", "UP Statistical Society proudly presents\n" +
            "The 10th Annual Stat-en-ekek: The Coolest Trivia Quiz Show About Anything and Everything Under the Sun!\n" +
            "In cooperation with The Study Place\n" +
            "Also brought to you by Philippine Statistics Authority (PSA), National Economic and Development Authority (NEDA), EastWest Bank, Birkenstock, and Gerry's Grill\n" +
            "Our media partners: WhenInManila, ClicktheCity, Circuit Magazine, BusinessWorld, and BusinessWorld Student Forum\n" +
            "See you there! ;)", "Just like the red poppies featured here which mean \"fun loving\" in Hanakotoba, UP Tomo-Kai wishes to bring you the fun loving spirit of Japan and the Philippines on its 25th year!\n" +
            "Join us in shouting out in glee at Hanakotoba's culminating event, Hiyaw: A Cultural Night.\n" +
            "Song and dance performances from our guests liven up the stage while you explore your way through Hiyaw's version of a gakuensai (school festival).\n" +
            "Visit various booths by UP Tomo-Kai as well as other Japan-related organizations from different schools, play games, and more!\n" +
            "---\n" +
            "This event is co-presented by ZALORA, MPIII, Jack 'n Jill Calbee Potato Chips, Nissin Yakisoba, Jack ‘n Jill Quake Overload, and ELMNO PH.\n" +
            "In cooperation with the UP Diliman-Office for Initiatives in Culture and the Arts (UP Diliman OICA).\n" +
            "Special thanks to Accenture in the Philippines\n" +
            "Partner Organizations: HallyUP, UP KAISA (K1), University of the Philippines Anime Manga Enthusiasts, UP Art Studies Society, UP Sandiwa, PNU NAMI, GakUEn-REALM, Thomasian Nihon Kyoukai, Hinomoto, and BPSU-FiNiCS.\n" +
            "Media Partners: arkadymac.com, magnetic-rose.net, DZUP, Wazzup Pilipinas, Post Your Event, AKTIVshow and 1 Digimedia Audiovisuals Inc.", "The UP Circle of Entrepreneurs, UP Diliman University Student Council, and the UP Business Administration Council,\n" +
            "\n" +
            "in cooperation with Globe,\n" +
            "\n" +
            "bring you the UP Entrep Fair!\n" +
            "\n" +
            "Catch the showcase of UP's innovative business ideas with 30 participating student entrepreneurs! Also, witness the official launch of the UP Student Entrepreneurship Center!\n" +
            "\n" +
            "Visit us on April 14 (Thursday) at the Sunken Garden starting 10 am!\n" +
            "\n" +
            "Also, drop by for a chance to win WiFi sticks from Globe and gift certificates from Fratello!\n" +
            "\n" +
            "Also brought to you by:\n" +
            "Metrobank | Silver Screen Photobooth\n" +
            "\n" +
            "Supported by:\n" +
            "Enterprise-DOST | University Freshie Council | Fratello | Pinas Media\n" +
            "\n" +
            "[This event is part of the UP Circle of Entrepreneurs Week.]"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages, prgmDesc));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}