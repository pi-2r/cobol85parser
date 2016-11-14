/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.environment.configuration.object.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.proleap.cobol.Cobol85Parser.AlphabetNameContext;
import io.proleap.cobol.Cobol85Parser.CharacterSetClauseContext;
import io.proleap.cobol.Cobol85Parser.CollatingSequenceClauseContext;
import io.proleap.cobol.Cobol85Parser.DiskSizeClauseContext;
import io.proleap.cobol.Cobol85Parser.MemorySizeClauseContext;
import io.proleap.cobol.Cobol85Parser.ObjectComputerParagraphContext;
import io.proleap.cobol.Cobol85Parser.SegmentLimitClauseContext;
import io.proleap.cobol.parser.metamodel.IntegerLiteral;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.CharacterSetClause;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.CollatingSequenceClause;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.DiskSizeClause;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.MemorySizeClause;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.ObjectComputerParagraph;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.SegmentLimitClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.valuestmt.ValueStmt;

public class ObjectComputerParagraphImpl extends CobolDivisionElementImpl implements ObjectComputerParagraph {

	private final static Logger LOG = LogManager.getLogger(ObjectComputerParagraphImpl.class);

	protected CharacterSetClause characterSetClause;

	protected CollatingSequenceClause collatingSequenceClause;

	protected final ObjectComputerParagraphContext ctx;

	protected DiskSizeClause diskSizeClause;

	protected MemorySizeClause memorySizeClause;

	protected String name;

	protected SegmentLimitClause segmentLimitClause;

	public ObjectComputerParagraphImpl(final String name, final ProgramUnit programUnit,
			final ObjectComputerParagraphContext ctx) {
		super(programUnit, ctx);

		this.name = name;
		this.ctx = ctx;
	}

	@Override
	public CharacterSetClause addCharacterSetClause(final CharacterSetClauseContext ctx) {
		CharacterSetClause result = (CharacterSetClause) getASGElement(ctx);

		if (result == null) {
			result = new CharacterSetClauseImpl(programUnit, ctx);

			characterSetClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public CollatingSequenceClause addCollatingSequenceClause(final CollatingSequenceClauseContext ctx) {
		CollatingSequenceClause result = (CollatingSequenceClause) getASGElement(ctx);

		if (result == null) {
			result = new CollatingSequenceClauseImpl(programUnit, ctx);

			for (final AlphabetNameContext alphabetNameContext : ctx.alphabetName()) {
				final String alphabetName = determineName(alphabetNameContext);
				result.addAlphabetName(alphabetName);
			}

			if (ctx.collatingSequenceClauseAlphanumeric() != null) {
				final String alphanumeric = determineName(ctx.collatingSequenceClauseAlphanumeric().alphabetName());
				result.setAlphaNumeric(alphanumeric);
			}

			if (ctx.collatingSequenceClauseNational() != null) {
				final String national = determineName(ctx.collatingSequenceClauseNational().alphabetName());
				result.setNational(national);
			}

			collatingSequenceClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public DiskSizeClause addDiskSizeClause(final DiskSizeClauseContext ctx) {
		DiskSizeClause result = (DiskSizeClause) getASGElement(ctx);

		if (result == null) {
			result = new DiskSizeClauseImpl(programUnit, ctx);

			/*
			 * size value stmt
			 */
			final ValueStmt valueStmt;

			if (ctx.integerLiteral() != null) {
				valueStmt = createIntegerLiteralValueStmt(ctx.integerLiteral());
			} else if (ctx.cobolWord() != null) {
				valueStmt = createCallValueStmt(ctx.cobolWord());
			} else {
				LOG.warn("unknown value stmt {}.", ctx);
				valueStmt = null;
			}

			result.setValueStmt(valueStmt);

			/*
			 * size unit
			 */
			final DiskSizeClause.Unit unit;

			if (ctx.WORDS() != null) {
				unit = DiskSizeClause.Unit.Words;
			} else if (ctx.MODULES() != null) {
				unit = DiskSizeClause.Unit.Modules;
			} else {
				unit = null;
			}

			result.setUnit(unit);

			diskSizeClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public MemorySizeClause addMemorySizeClause(final MemorySizeClauseContext ctx) {
		MemorySizeClause result = (MemorySizeClause) getASGElement(ctx);

		if (result == null) {
			result = new MemorySizeClauseImpl(programUnit, ctx);

			/*
			 * size value stmt
			 */
			final ValueStmt valueStmt;

			if (ctx.integerLiteral() != null) {
				valueStmt = createIntegerLiteralValueStmt(ctx.integerLiteral());
			} else if (ctx.cobolWord() != null) {
				valueStmt = createCallValueStmt(ctx.cobolWord());
			} else {
				LOG.warn("unknown value stmt {}.", ctx);
				valueStmt = null;
			}

			result.setValueStmt(valueStmt);

			/*
			 * size unit
			 */
			final MemorySizeClause.Unit unit;

			if (ctx.WORDS() != null) {
				unit = MemorySizeClause.Unit.Words;
			} else if (ctx.CHARACTERS() != null) {
				unit = MemorySizeClause.Unit.Characters;
			} else if (ctx.MODULES() != null) {
				unit = MemorySizeClause.Unit.Modules;
			} else {
				unit = null;
			}

			result.setUnit(unit);

			memorySizeClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public SegmentLimitClause addSegmentLimitClause(final SegmentLimitClauseContext ctx) {
		SegmentLimitClause result = (SegmentLimitClause) getASGElement(ctx);

		if (result == null) {
			result = new SegmentLimitClauseImpl(programUnit, ctx);

			final IntegerLiteral integerLiteral = addIntegerLiteral(ctx.integerLiteral());
			result.setIntegerLiteral(integerLiteral);

			segmentLimitClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public CharacterSetClause getCharacterSetClause() {
		return characterSetClause;
	}

	@Override
	public CollatingSequenceClause getCollatingSequenceClause() {
		return collatingSequenceClause;
	}

	@Override
	public DiskSizeClause getDiskSizeClause() {
		return diskSizeClause;
	}

	@Override
	public MemorySizeClause getMemorySizeClause() {
		return memorySizeClause;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public SegmentLimitClause getSegmentLimitClause() {
		return segmentLimitClause;
	}

}
