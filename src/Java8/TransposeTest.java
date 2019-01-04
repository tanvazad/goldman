/*
package Java8;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TransposeTest {

    @Test
    public void testTranspose() {

	// given
	List<Map<Integer, Object>> columnWiseData = getColumnWiseData();

	// when
	List<Map<Integer, Object>> result = transpose(columnWiseData);

	// then
	List<Map<Integer, Object>> expected = getRowWiseData();
	assertEquals(expected, result);

    }

*
     * A grid with 2 columns, having IDs 24016 and 24017. We can represent the
     * data column-wise or row-wise. This method takes in the column-wise data
     * and converts to row-wise data.


    private List<Map<Integer, Object>> transpose(List<Map<Integer, Object>> columnWiseData) {
	// TODO: implemnent using Streams
	throw new UnsupportedOperationException();
    }

    private List<Map<Integer, Object>> getColumnWiseData() {
	List<Map<Integer, Object>> columnWiseData = new ArrayList<>();

	Map<Integer, Object> col1 = new HashMap<>();
	col1.put(24016, 1.0);
	col1.put(24016, 2.0);
	col1.put(24016, 3.0);
	col1.put(24016, 4.0);

	columnWiseData.add(col1);

	Map<Integer, Object> col2 = new HashMap<>();
	col2.put(24017, "A");
	col2.put(24017, "B");
	col2.put(24017, "C");
	col2.put(24017, "D");
	columnWiseData.add(col2);

	return columnWiseData;
    }

    private List<Map<Integer, Object>> getRowWiseData() {
	List<Map<Integer, Object>> rowWiseData = new ArrayList<>();

	Map<Integer, Object> row1 = new HashMap<>();
	row1.put(24016, 1.0);
	row1.put(24017, "A");
	rowWiseData.add(row1);

	Map<Integer, Object> row2 = new HashMap<>();
	row2.put(24016, 2.0);
	row2.put(24017, "B");
	rowWiseData.add(row2);

	Map<Integer, Object> row3 = new HashMap<>();
	row3.put(24016, 3.0);
	row3.put(24017, "C");
	rowWiseData.add(row3);

	Map<Integer, Object> row4 = new HashMap<>();
	row4.put(24016, 4.0);
	row4.put(24017, "D");
	rowWiseData.add(row4);

	return rowWiseData;
    }

}
*/
