package parser_practice;

import java.io.File;
import java.util.List;
import lib6005.parser.*;

public class First 
{
    // data type for the parser:
    enum IntegerGrammar {ROOT, SUM, PRIMITIVE, NUMBER, WHITESPACE};
    //enum IntegerGrammar {ROOT, SUM,, NUMBER, WHITESPACE};

    /**
     * Traverse a parse tree, indenting to make it easier to read.
     * @param node
     * Parse tree to print.
     * @param indent
     * Indentation to use.
     */
    private static void visitAll(ParseTree<IntegerGrammar> node, String indent){
        if(node.isTerminal()){
            System.out.println(indent + node.getName() + ":" + node.getContents());
        }else{
            System.out.println(indent + node.getName());
            for(ParseTree<IntegerGrammar> child: node){
                visitAll(child, indent + "   ");
            }
        }
    }

    /**
     * Function converts a ParseTree to an IntegerExpression. 
     * @param p
     *  ParseTree<IntegerGrammar> that is assumed to have been constructed by the grammar in IntegerExpression.g
     * @return
     */
    private static IntegerExpression buildAST(ParseTree<IntegerGrammar> p){
        switch(p.getName()){
            /*
             * Since p is a ParseTree parameterized by the type IntegerGrammar, p.getName() 
             * returns an instance of the IntegerGrammar enum. This allows the compiler to check
             * that we have covered all the cases.
             */
            case NUMBER:
            /*
             * A number will be a terminal containing a number.
             */
            return new Number(Integer.parseInt(p.getContents()));
            case PRIMITIVE:
            /*
             * A primitive will have either a number or a sum as child (in addition to some whitespace)
             * By checking which one, we can determine which case we are in.
             */             

            if(p.childrenByName(IntegerGrammar.NUMBER).isEmpty()){
                return buildAST(p.childrenByName(IntegerGrammar.SUM).get(0));
            }else{
                return buildAST(p.childrenByName(IntegerGrammar.NUMBER).get(0));
            }

            case SUM:
            /*
             * A sum will have one or more children that need to be summed together.
             * Note that we only care about the children that are primitive. There may also be 
             * some whitespace children which we want to ignore.
             */
            boolean first = true;
            IntegerExpression result = null;
            for(ParseTree<IntegerGrammar> child : p.childrenByName(IntegerGrammar.PRIMITIVE)){                
                if(first){
                    result = buildAST(child);
                    first = false;
                }else{
                    result = new Plus(result, buildAST(child));
                }
            }
            if (first) {
                throw new RuntimeException("sum must have a non whitespace child:" + p);
            }
            return result;
            case ROOT:
            /*
             * The root has a single sum child, in addition to having potentially some whitespace.
             */
            return buildAST(p.childrenByName(IntegerGrammar.SUM).get(0));
            case WHITESPACE:
            /*
             * Since we are always avoiding calling buildAST with whitespace, 
             * the code should never make it here. 
             */
            throw new RuntimeException("You should never reach here:" + p);
        }   
        /*
         * The compiler should be smart enough to tell that this code is unreachable, but it isn't.
         */
        throw new RuntimeException("You should never reach here:" + p);
    }

    public static void main(String[] argv) throws lib6005.parser.UnableToParseException, java.io.IOException
    {
        // initialising the parser
        Parser<IntegerGrammar> parser =
            GrammarCompiler.compile(new File("parser_practice/IntegerExpression.g"), IntegerGrammar.ROOT);
        // parser can be fed with: string, InputStream, a File or a Reader and it returns a ParseTree
        ParseTree<IntegerGrammar> tree = parser.parse("5+2+3+21");
        // toString()
        System.out.println("The tree: " + tree);
        // visualisation in browser
        tree.display();

        // important methods:
        // contents as string
        System.out.println("Contents of the tree as string: " + tree.getContents());

        // children nodes of the ParseTree node List<ParseTree<Symbols> threw an error of unknown "Symbol"
        List tree_children = tree.children();
        System.out.println("The children of the node: " + tree_children);
        int tree_size = tree_children.size();
        System.out.println("size of tree_children: " + tree_size);
        for (int i = 0; i < tree_size; ++i)
            System.out.println("\t" + tree_children.get(i));
        System.out.println("Is it terminal? " + tree.isTerminal());
        System.out.println("What is its name? " + tree.getName());
        List child_names = tree.childrenByName(IntegerGrammar.NUMBER);
        int child_name_size = child_names.size();
        System.out.println("size of names: " + child_name_size);

        System.out.println("Visiting all members of the tree:");
        visitAll(tree,"\t");
        
        System.out.print("AST: ");
        IntegerExpression ip = buildAST(tree);
        System.out.println(ip + "==" + ip.eval());
    }
}
