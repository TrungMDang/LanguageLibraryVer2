package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Clause Table Model.
 * @author Emrullah Celik
 * @version 12/02/15
 *
 */
@SuppressWarnings("serial")
public class ClauseTableModel extends AbstractTableModel {

    private static final int TITLE_COL = 0;
    private static final int KEYWORD_COL = 1;
    private static final int DESCRIPTION_COL = 2;
    private static final int TEXT_COL = 3;

    private String[] columnNames = { "Title", "Keyword", "Description",
            "Text" };
    private List<Clause> clauses;

    public ClauseTableModel(List<Clause> theClauses) {
        clauses = theClauses;
    }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return clauses.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Clause tempClause = clauses.get(row);

        switch (col) {
        case TITLE_COL:
            return tempClause.gettitle();
        case KEYWORD_COL:
            return tempClause.getkeyword();
        case DESCRIPTION_COL:
            return tempClause.getdescription();
        case TEXT_COL:
            return tempClause.gettext();
        default:
            return tempClause.getkeyword();
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
