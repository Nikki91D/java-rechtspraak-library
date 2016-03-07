package org.crf.postagging.postaggers.crf;

import java.util.List;

import org.crf.crf.run.CrfInferencePerformer;
import org.crf.postagging.postaggers.PosTagger;
import org.crf.utilities.TaggedToken;

/**
 * A part-of-speech tagger which assigns the tags using CRF inference. CRF is an acronym of Conditional Random Fields.
 * 
 * @author Asher Stern
 * Date: Nov 10, 2014
 *
 */
public class CrfPosTagger implements PosTagger
{
	public CrfPosTagger(CrfInferencePerformer<String, String> inferencePerformer)
	{
		this.inferencePerformer = inferencePerformer;
	}

	@Override
	public List<TaggedToken<String,String>> tagSentence(List<String> sentence)
	{
		return inferencePerformer.tagSequence(sentence);
	}
	
	
	private final CrfInferencePerformer<String, String> inferencePerformer;

}
