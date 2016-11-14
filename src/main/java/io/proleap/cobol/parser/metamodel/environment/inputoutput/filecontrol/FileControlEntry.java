/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.environment.inputoutput.filecontrol;

import io.proleap.cobol.Cobol85Parser.AccessModeClauseContext;
import io.proleap.cobol.Cobol85Parser.AlternateRecordKeyClauseContext;
import io.proleap.cobol.Cobol85Parser.AssignClauseContext;
import io.proleap.cobol.Cobol85Parser.FileStatusClauseContext;
import io.proleap.cobol.Cobol85Parser.OrganizationClauseContext;
import io.proleap.cobol.Cobol85Parser.PaddingCharacterClauseContext;
import io.proleap.cobol.Cobol85Parser.PasswordClauseContext;
import io.proleap.cobol.Cobol85Parser.RecordDelimiterClauseContext;
import io.proleap.cobol.Cobol85Parser.RecordKeyClauseContext;
import io.proleap.cobol.Cobol85Parser.RelativeKeyClauseContext;
import io.proleap.cobol.Cobol85Parser.ReserveClauseContext;
import io.proleap.cobol.Cobol85Parser.SelectClauseContext;
import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.NamedElement;

public interface FileControlEntry extends CobolDivisionElement, NamedElement {

	AccessModeClause addAccessModeClause(AccessModeClauseContext ctx);

	AlternateRecordKeyClause addAlternateRecordKeyClause(AlternateRecordKeyClauseContext ctx);

	AssignClause addAssignClause(AssignClauseContext ctx);

	FileStatusClause addFileStatusClause(FileStatusClauseContext ctx);

	OrganizationClause addOrganizationClause(OrganizationClauseContext ctx);

	PaddingCharacterClause addPaddingCharacterClause(PaddingCharacterClauseContext ctx);

	PasswordClause addPasswordClause(PasswordClauseContext ctx);

	RecordDelimiterClause addRecordDelimiterClause(RecordDelimiterClauseContext ctx);

	RecordKeyClause addRecordKeyClause(RecordKeyClauseContext ctx);

	RelativeKeyClause addRelativeKeyClause(RelativeKeyClauseContext ctx);

	ReserveClause addReserveClause(ReserveClauseContext ctx);

	SelectClause addSelectClause(SelectClauseContext ctx);

	AccessModeClause getAccessModeClause();

	AlternateRecordKeyClause getAlternateRecordKeyClause();

	AssignClause getAssignClause();

	FileStatusClause getFileStatusClause();

	OrganizationClause getOrganizationClause();

	PaddingCharacterClause getPaddingCharacterClause();

	PasswordClause getPasswordClause();

	RecordDelimiterClause getRecordDelimiterClause();

	RecordKeyClause getRecordKeyClause();

	RelativeKeyClause getRelativeKeyClause();

	ReserveClause getReserveClause();

	SelectClause getSelectClause();

}
