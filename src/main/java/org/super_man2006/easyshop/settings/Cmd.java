package org.super_man2006.easyshop.settings;

import org.apache.commons.io.FileUtils;
import org.super_man2006.custom_item_api.utils.IsInt;
import org.super_man2006.easyshop.EasyShop;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class Cmd {

    static File file = new File(EasyShop.plugin.getDataFolder(), "cmd.txt");

    public static int background = -1;

    public static int backbutton = -1;

    public static int buyone = -1;
    public static int buytwo = -1;
    public static int buyfour = -1;
    public static int buyeight = -1;
    public static int buysixteen = -1;
    public static int buythirtytwo = -1;
    public static int buysixtyfour = -1;
    public static int buyonehundredtwentyeight = -1;
    public static int buytwohundredfiftysix = -1;

    public static int sellone = -1;
    public static int selltwo = -1;
    public static int sellfour = -1;
    public static int selleight = -1;
    public static int sellsixteen = -1;
    public static int sellthirtytwo = -1;
    public static int sellsixtyfour = -1;
    public static int sellonehundredtwentyeight = -1;
    public static int selltwohundredfiftysix = -1;

    public static void get() {
        try {
            List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());

            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).replaceAll(" ", ""));
                if (lines.get(i).equals("") || lines.get(i).startsWith("#")) {
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("background=")) {
                    lines.set(i, lines.get(i).replace("background=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        background = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("backbutton=")) {
                    lines.set(i, lines.get(i).replace("backbutton=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        backbutton = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buyone=")) {
                    lines.set(i, lines.get(i).replace("buyone=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buyone = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buytwo=")) {
                    lines.set(i, lines.get(i).replace("buytwo=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buytwo = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buyfour=")) {
                    lines.set(i, lines.get(i).replace("buyfour=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buyfour = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buyeight=")) {
                    lines.set(i, lines.get(i).replace("buyeight=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buyeight = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buysixteen=")) {
                    lines.set(i, lines.get(i).replace("buysixteen=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buysixteen = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buythirtytwo=")) {
                    lines.set(i, lines.get(i).replace("buythirtytwo=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buythirtytwo = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buysixtyfour=")) {
                    lines.set(i, lines.get(i).replace("buysixtyfour=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buysixtyfour = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buyonehundredtwentyeight")) {
                    lines.set(i, lines.get(i).replace("buyonehundredtwentyeight=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buyonehundredtwentyeight = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("buytwohundredfiftysix")) {
                    lines.set(i, lines.get(i).replace("buytwohundredfiftysix=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        buytwohundredfiftysix = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellone=")) {
                    lines.set(i, lines.get(i).replace("sellone=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellone = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("selltwo=")) {
                    lines.set(i, lines.get(i).replace("selltwo=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        selltwo = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellfour=")) {
                    lines.set(i, lines.get(i).replace("sellfour=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellfour = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("selleight=")) {
                    lines.set(i, lines.get(i).replace("selleight=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        selleight = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellsixteen=")) {
                    lines.set(i, lines.get(i).replace("sellsixteen=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellsixteen = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellthirtytwo=")) {
                    lines.set(i, lines.get(i).replace("sellthirtytwo=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellthirtytwo = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellsixtyfour=")) {
                    lines.set(i, lines.get(i).replace("sellsixtyfour=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellsixtyfour = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("sellonehundredtwentyeight")) {
                    lines.set(i, lines.get(i).replace("sellonehundredtwentyeight=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        sellonehundredtwentyeight = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

                if (lines.get(i).startsWith("selltwohundredfiftysix")) {
                    lines.set(i, lines.get(i).replace("selltwohundredfiftysix=", ""));
                    if (IsInt.IsInt(lines.get(i))) {
                        selltwohundredfiftysix = Integer.parseInt(lines.get(i));
                    }
                    lines.remove(i);
                    continue;
                }

            }


            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
