package com.ecl.calculatrice;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static String buttonsTextID[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "point", "diviser", "multiplier", "soustraire", "additionner","res"};
    public static ArrayList<Button> buttonsClicked;
    public static double result;
    private TextView _affichage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            findViewById(R.id.button_rad).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = result*Math.PI/180;
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_deg).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = result*180/Math.PI;
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_cos).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.cos(result);
                    _affichage.setText(Double.toString(result));
                }
            });
            findViewById(R.id.button_sin).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.sin(result);
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_tan).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.tan(result);
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_abs).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.abs(result);
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_exp).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.exp(result);
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_ln).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.log(result);
                    _affichage.setText(Double.toString(result));
                }
            });

            findViewById(R.id.button_carre).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.pow(result,2);
                    _affichage.setText(Double.toString(result));
                }
            });
            
            findViewById(R.id.button_sqrt).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());
                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }
                    result = Math.sqrt( result );
                    _affichage.setText(Double.toString(result));
                }
            });
        }


            buttonsClicked = new ArrayList<>();
            result = 0;
            _affichage = findViewById(R.id.affichage);

            for (int i = 0; i < buttonsTextID.length; i++) {
                final int buttonID = getResources().getIdentifier("button_" + buttonsTextID[i], "id", getPackageName());
                final Button button = findViewById(buttonID);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onButtonClicked(button);
                    }
                });
            }

            findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonsClicked.size() > 0) {
                        String oldText = _affichage.getText().toString();
                        Button canceledButton = buttonsClicked.get(buttonsClicked.size() - 1);

                        _affichage.setText(oldText.substring(0, oldText.length() - canceledButton.getText().length()));
                        buttonsClicked.remove(buttonsClicked.size() - 1);
                    }
                }
            });


            findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _affichage.setText("");
                    buttonsClicked.removeAll(buttonsClicked);
                }
            });

            findViewById(R.id.button_result).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calcul calcul = new Calcul(0, buttonsClicked.size());

                    try {
                        result = calcul.getResult();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        buttonsClicked.removeAll(buttonsClicked);
                    }

                    _affichage.setText(Double.toString(result));
                }
            });
    }

    private void onButtonClicked(Button button) {
        if (buttonsClicked.isEmpty()) {
            _affichage.setText("");

            if (isOperator(button)) {
                Button button_res = findViewById(R.id.button_res);
                buttonsClicked.add(button_res);
                _affichage.append(button_res.getText());
            }
        }

        buttonsClicked.add(button);
        _affichage.append(button.getText());

    }

    public static boolean isOperator(Button button) {
        boolean bool = false;

        int buttonID = button.getId();
        bool = bool || buttonID == R.id.button_additionner || buttonID == R.id.button_soustraire;
        bool = bool || buttonID == R.id.button_multiplier || buttonID == R.id.button_diviser;

        return bool;
    }


}
