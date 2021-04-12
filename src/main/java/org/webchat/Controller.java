package org.webchat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class Controller {

    private static List<Line> lines = new ArrayList<>();

    @RequestMapping("/add_line")
    public int addLine(String text) {
        Line line = new Line(lines.size() + 1, text);
        lines.add(line);

        return line.getNumber();
    }

    @RequestMapping("/get_lines")
    public List<Line> getLines(int number) {
        List<Line> result = new ArrayList<>();

        for (; number < lines.size(); number++) {
            result.add(lines.get(number));
        }

        return result;
    }
}
