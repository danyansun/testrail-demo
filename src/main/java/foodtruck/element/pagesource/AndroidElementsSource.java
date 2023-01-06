package foodtruck.element.pagesource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michelle
 */
public class AndroidElementsSource {
    //    private final String source;
    private final List<SourceElement> sourceElements;

    public AndroidElementsSource(String source) {
//        this.source = source;
        sourceElements = interpret(source);
    }

    public VirtualElement findElement(String testID) {
        String formattedTestID = testID
                .replace("&", "&amp;")
                .replace("\"", "&quot;");
        return sourceElements.stream().filter(sourceElement -> Objects.equals(formattedTestID, sourceElement.formattedTestID))
                .findAny().map(SourceElement::get)
                .orElse(null);
    }

    public VirtualElement findElementContains(String partialTestID) {
        String formattedPartialTestID = partialTestID
                .replace("&", "&amp;")
                .replace("\"", "&quot;");
        return sourceElements.stream().filter(sourceElement -> sourceElement.formattedTestID.contains(formattedPartialTestID))
                .findAny().map(SourceElement::get)
                .orElse(null);
    }

    private List<SourceElement> interpret(String source) {
        ArrayList<SourceElement> result = new ArrayList<>();
        Pattern elementXmlPattern = Pattern.compile("<android.*content-desc=\"([^\"]+)\".*>");
        Matcher matcher = elementXmlPattern.matcher(source);
        while (matcher.find()) {
            SourceElement sourceElement = new SourceElement();
            sourceElement.elementXml = matcher.group();
            sourceElement.formattedTestID = matcher.group(1);
            result.add(sourceElement);
        }
        return result;
    }

    private static class SourceElement {
        private String elementXml;
        private String formattedTestID;

        private VirtualElement get() {
            Pattern boundsPattern = Pattern.compile("bounds=\"\\[([0-9]+),([0-9]+)]\\[([0-9]+),([0-9]+)]\"");
            Pattern textPattern = Pattern.compile("text=\"([^\"]*)\"");
            Pattern displayedPattern = Pattern.compile("displayed=\"([^\"]*)\"");
            Matcher boundsMatcher = boundsPattern.matcher(elementXml);
            Matcher textMatcher = textPattern.matcher(elementXml);
            Matcher displayedMatcher = displayedPattern.matcher(elementXml);
            if (!boundsMatcher.find() || !textMatcher.find() || !displayedMatcher.find()) {
                throw new RuntimeException("Unable to parse xml: " + elementXml);
            }
            int x = Integer.parseInt(boundsMatcher.group(1));
            int y = Integer.parseInt(boundsMatcher.group(2));
            int width = Integer.parseInt(boundsMatcher.group(3)) - x;
            int height = Integer.parseInt(boundsMatcher.group(4)) - y;
            Boolean cacheDisplayed = Boolean.valueOf(displayedMatcher.group(1));
            String testID = this.formattedTestID.replace("&amp;", "&").replace("&quot;", "\"");
            return new VirtualElement(testID, new Bounds(x, y, width, height))
                    .setText(textMatcher.group(1))
                    .setCacheDisplayed(cacheDisplayed);
        }
    }
}
