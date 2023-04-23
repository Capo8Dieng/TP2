package com.example.tp2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "TP2";//pour identifier la provenance du message
    private TextView textView;
    private final int[] tableau = new int[]{1, 3, 6, 8, 9};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Démarrage de l'activité"); //permet d'afficher un message système
        textView = findViewById(R.id.textview);
        display(tableau);
    }
    private void display(int[] tab)
    {
        textView.setText(Arrays.toString(tab));
    }
    /** appelée quand on clique sur le bouton */
    public void onPermuter(View view)
    {
        Log.i(TAG, "clic sur le bouton Permuter");
        permutation(tableau);
        display(tableau);
    }
    /**
     * fait une permutation circulaire croissante des valeurs :
     * [a, b, c, d] => [d, a, b, c]
     * @param tab tableau à permuter
     */
    private void permutation(int[] tab)
    {
        int dernier = tab[tab.length-1];
        for (int i=tab.length-2; i>-1; i--) {
            recopierSurSuivant(tab,i);
        }
        tab[0] = dernier;
    }
    /**
     * place la valeur de la case pos du tableau tab dans la case pos+1
     * @param tab tableau à permuter
     * @param pos indice de l'élément à copier sur le suivant
     */
    private void recopierSurSuivant(int[] tab, int pos)
    {
        int courant = tab[pos];
        tab[pos]=tab[pos+1];
        tab[pos+1]=courant;
    }
}
