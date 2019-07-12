package snmaddula.hawk.bitbucket.domain;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author snmaddula
 *
 * @param <T>
 */
@Data
public class GResponse<T> {

    protected Integer size;
    protected Integer limit;
    protected boolean isLastPage;
	protected List<T> values;
	
}
