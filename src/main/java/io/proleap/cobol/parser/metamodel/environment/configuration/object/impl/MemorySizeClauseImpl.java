/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.environment.configuration.object.impl;

import io.proleap.cobol.Cobol85Parser.MemorySizeClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.environment.configuration.object.MemorySizeClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.valuestmt.ValueStmt;

public class MemorySizeClauseImpl extends CobolDivisionElementImpl implements MemorySizeClause {

	protected final MemorySizeClauseContext ctx;

	protected Unit unit;

	protected ValueStmt valueStmt;

	public MemorySizeClauseImpl(final ProgramUnit programUnit, final MemorySizeClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public ValueStmt getValueStmt() {
		return valueStmt;
	}

	@Override
	public void setUnit(final Unit unit) {
		this.unit = unit;
	}

	@Override
	public void setValueStmt(final ValueStmt valueStmt) {
		this.valueStmt = valueStmt;
	}

}
