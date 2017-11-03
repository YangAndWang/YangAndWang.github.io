package com.learnwy.system.dto

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.*

const val TABLE_NAME_PATH = SystemConfig.PREFIX + SystemConfig.DELIMITER + "path"

@Entity(name = TABLE_NAME_PATH)
data class Path(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long,
	@Column( length=256 )
	var name: String,
	@Column( length=1024 )
	var description: String,
	@Column( length=1024 )
	var displayName: String,
	var userPermission: Long,
	var groupPermission: Long,
	var otherPermission: Long,
	var ownUserId: Long,
	var ownGroupId: Long,
	var createDate: Date,
	var createUserId: Long,
	var createGroupId: Long,
	var updateDate: Date,
	var updateUserId: Long,
	var updateGroupId: Long,
	var objectVersionNumber: Long
) {
}