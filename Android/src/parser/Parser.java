/* Generated By:JavaCC: Do not edit this line. Parser.java */
package parser;
import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;

public class Parser implements ParserConstants {

// primitive logo (une chaine de caract�re compos� de lettre uniquement)		-------------------
  final public Object primitive() throws ParseException {
  Token prim;
    prim = jj_consume_token(ID);
    {if (true) return (Object) prim.image;}
    throw new Error("Missing return statement in function");
  }

// expression -> simpleExp | listExp		-------------------------------------------------------
  final public Object expression() throws ParseException {
  List < Object > list = null;
  Object simple = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 5:
    case ID:
    case NUMBER:
      simple = simpleExp();
    {if (true) return simple;}
      break;
    case 7:
      list = listExp();
    {if (true) return list;}
      break;
    case 0:
      jj_consume_token(0);
    {if (true) return null;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// listExp -> "[" (expression)* "]"		-----------------------------------------------------------
  final public List < Object > listExp() throws ParseException {
  @ SuppressWarnings(
  {
    "rawtypes"
  }
  ) List < Object > instrList = new ArrayList < Object > ();
  Object obj;
    jj_consume_token(7);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 0:
      case 5:
      case 7:
      case ID:
      case NUMBER:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      obj = expression();
      instrList.add(obj);
    }
    jj_consume_token(8);
    {if (true) return instrList;}
    throw new Error("Missing return statement in function");
  }

// simpleExp -> addExp		-----------------------------------------------------------------------
  final public Object simpleExp() throws ParseException {
  Object obj = "";
    obj = addExp();
    {if (true) return obj;}
    throw new Error("Missing return statement in function");
  }

// addExp -> multExp (("+"|"-") multExp)*		-----------------------------------------------------------
  final public Object addExp() throws ParseException {
  Object larg = null;
  Object rarg;
    larg = multExp();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
      case 10:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        jj_consume_token(9);
        rarg = multExp();
      larg = String.valueOf(Integer.parseInt((String) larg) + Integer.parseInt((String) rarg));
        break;
      case 10:
        jj_consume_token(10);
        rarg = multExp();
      larg = String.valueOf(Integer.parseInt((String) larg) - Integer.parseInt((String) rarg));
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return larg;}
    throw new Error("Missing return statement in function");
  }

// multExp -> primaryExp (("*" | "/") primaryExp)*		-------------------------------------------
  final public Object multExp() throws ParseException {
  Object larg;
  Object rarg;
    larg = primaryExp();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 11:
      case 12:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 11:
        jj_consume_token(11);
        rarg = primaryExp();
      larg = String.valueOf(Integer.parseInt((String) larg) * Integer.parseInt((String) rarg));
        break;
      case 12:
        jj_consume_token(12);
        rarg = primaryExp();
      larg = String.valueOf(Integer.parseInt((String) larg) / Integer.parseInt((String) rarg));
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return larg;}
    throw new Error("Missing return statement in function");
  }

// primaryExp -> primitive | NUMBER | "(" simpleExp ")"		---------------------------------------
  final public Object primaryExp() throws ParseException {
  Token t;
  Object obj;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      obj = primitive();
    {if (true) return obj;}
      break;
    case NUMBER:
      t = jj_consume_token(NUMBER);
    obj = t.image;
    {if (true) return obj;}
      break;
    case 5:
      jj_consume_token(5);
      obj = simpleExp();
      jj_consume_token(6);
    {if (true) return obj;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

// variable -> ":"primitive
  final public Object variable() throws ParseException {
  Object obj;
    jj_consume_token(13);
    obj = primitive();
    {if (true) return obj;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x140a1,0x140a1,0x600,0x600,0x1800,0x1800,0x14020,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

 }
