import tester.*;

class ImageData {
  String keywords; // All the keywords, separated by spaces
  String filetype; // .gif, .png, .jpg, and so on
  int width;
  int height;
  ImageData(String keywords, String filetype, int width, int height) {
    this.keywords = keywords;
    this.filetype = filetype;
    this.width = width;
    this.height = height;
  }
}

interface ImageQuery {
  boolean matches(ImageData id);
  ImageQuery and(ImageQuery other);
  ImageQuery or(ImageQuery other);
}

abstract class AQuery implements ImageQuery {
  public ImageQuery and(ImageQuery other) {
    return new AndQuery(this, other);
  }
  public ImageQuery or(ImageQuery other) {
    return new OrQuery(this, other);
  }
}

abstract class AComboQuery extends AQuery {
  ImageQuery iq1, iq2;
  AComboQuery(ImageQuery iq1, ImageQuery iq2) {
    this.iq1 = iq1;
    this.iq2 = iq2;
  }
}

class ContainsKeyword extends AQuery {
  String keyword;
  ContainsKeyword(String keyword) {
    this.keyword = keyword;
  }
  public boolean matches(ImageData id) {
    return id.keywords.indexOf(this.keyword) != -1;
  }
}

class LargerThan extends AQuery {
  int minWidth, minHeight;
  LargerThan(int minWidth, int minHeight) {
    this.minWidth = minWidth;
    this.minHeight = minHeight;
  }
  public boolean matches(ImageData id) {
    return id.width >= this.minWidth && id.height >= this.minHeight;
  }
}

class MatchesExtension extends AQuery {
  String ext;
  MatchesExtension(String ext) { this.ext = ext; }
  public boolean matches(ImageData id) {
    return id.filetype.equals(this.ext);
  }
}

class AndQuery extends AComboQuery {
  AndQuery(ImageQuery iq1, ImageQuery iq2) {
    super(iq1, iq2);
  }
  public boolean matches(ImageData id) {
    return this.iq1.matches(id) && this.iq2.matches(id);
  }
}

class OrQuery extends AComboQuery {
  OrQuery(ImageQuery iq1, ImageQuery iq2) {
    super(iq1, iq2);
  }
  public boolean matches(ImageData id) {
    return this.iq1.matches(id) || this.iq2.matches(id);
  }
}

class NotQuery extends AQuery {
  ImageQuery iq;
  NotQuery(ImageQuery iq) {
    this.iq = iq;
  }
  public boolean matches(ImageData id) {
    return !this.iq.matches(id);
  }
}


class ExamplesSearch {
  ImageData i1 = new ImageData("ucsd cse computer science", "png", 600, 400);
  ImageData i2 = new ImageData("data science ai artificial intelligence", "png", 500, 400);
  ImageQuery lg1 = new LargerThan(600, 400);
  ImageQuery me1 = new MatchesExtension("png");
  ImageQuery ck1 = new ContainsKeyword("ucsd");
  ImageQuery all3 = this.lg1.and(this.me1).and(this.ck1);
  ImageQuery all3Or = this.lg1.or(this.me1).or(this.ck1);
  ImageQuery mixed = this.lg1.or(this.me1.and(new ContainsKeyword("ai")));
  boolean testAnd(Tester t) {
    return t.checkExpect(this.all3.matches(i1), true) &&
           t.checkExpect(this.all3.matches(i2), false);
  }
  boolean testOr(Tester t) {
    return t.checkExpect(this.all3Or.matches(i1), true) &&
           t.checkExpect(this.all3Or.matches(i2), true);
  }
  boolean testMixed(Tester t) {
    return t.checkExpect(this.mixed.matches(i1), true) &&
           t.checkExpect(this.mixed.matches(i2), true);
  }
}
