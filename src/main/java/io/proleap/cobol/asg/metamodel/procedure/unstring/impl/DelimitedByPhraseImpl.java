/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.unstring.impl;

import io.proleap.cobol.Cobol85Parser.UnstringDelimitedByPhraseContext;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.asg.metamodel.procedure.unstring.DelimitedByPhrase;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;

public class DelimitedByPhraseImpl extends CobolDivisionElementImpl implements DelimitedByPhrase {

	protected final UnstringDelimitedByPhraseContext ctx;

	protected ValueStmt delimitedByValueStmt;

	public DelimitedByPhraseImpl(final ProgramUnit programUnit, final UnstringDelimitedByPhraseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public ValueStmt getDelimitedByValueStmt() {
		return delimitedByValueStmt;
	}

	@Override
	public void setDelimitedByValueStmt(final ValueStmt delimitedByValueStmt) {
		this.delimitedByValueStmt = delimitedByValueStmt;
	}

}