package com.edicoding.picodiploma.moviecatalogue.model;

import android.content.Context;

import com.edicoding.picodiploma.moviecatalogue.R;

import java.util.ArrayList;

public class MovieData {

    public static ArrayList<Movie> getListData(){
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie(R.drawable.poster_aquaman,"Aquaman", "December 21, 2018","Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."));
        list.add(new Movie(R.drawable.poster_avengerinfinity,"Avengers: Infinity War", "April 23, 2018","As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        list.add(new Movie(R.drawable.poster_venom,"Venom", "October 1, 2018","Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own."));
        list.add(new Movie(R.drawable.poster_bohemian,"Bohemian Rhapsody ", "October 30, 2018","Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."));
        list.add(new Movie(R.drawable.poster_bumblebee,"Bumblebee", "December 21, 2018","On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug."));
        list.add(new Movie(R.drawable.poster_creed,"Creed", " November 14, 2018","Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.\n" +
                "\n"));
        list.add(new Movie(R.drawable.poster_deadpool,"Once Upon a Deadpool ", "December 11, 2018","A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.\n" +
                "\n"));
        list.add(new Movie(R.drawable.poster_glass,"Glass", "January 18, 2019","In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."));
        list.add(new Movie(R.drawable.poster_mortalengine,"Mortal Engines", "December 14, 2018","Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.\n" +
                "\n"));
        list.add(new Movie(R.drawable.poster_a_star,"A Star Is Born", "October 5, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."));

        return list;
    }
}
